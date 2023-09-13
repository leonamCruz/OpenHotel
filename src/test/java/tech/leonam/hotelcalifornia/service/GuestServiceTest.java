package tech.leonam.hotelcalifornia.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.leonam.hotelcalifornia.model.dto.guest.GuestRegisterDto;
import tech.leonam.hotelcalifornia.model.dto.guest.GuestResponseDto;
import tech.leonam.hotelcalifornia.repository.GuestRespository;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static tech.leonam.hotelcalifornia.util.Copy.EntityToDtoResponse;
import static tech.leonam.hotelcalifornia.util.Copy.RegisterDtoToEntity;
import static tech.leonam.hotelcalifornia.util.FakePeople.createContactDto;
import static tech.leonam.hotelcalifornia.util.FakePeople.createContactEntity;

@ExtendWith(MockitoExtension.class)
public class GuestServiceTest {
    private GuestService guestService;
    private GuestRespository guestRespository;

    @Before
    public void setup() {
        guestRespository = Mockito.mock(GuestRespository.class);
        guestService = new GuestService(guestRespository);
    }
    @Test
    public void findByCpfTest() {
        when(guestRespository.findByDocument(createContactDto().getCpf())).thenReturn(createContactEntity());
        GuestRegisterDto people = createContactDto();
        GuestResponseDto peopleSearchCpf = guestService.getByDocument(people.getCpf());
        GuestResponseDto peopleResponseDto = EntityToDtoResponse(RegisterDtoToEntity(people));

        var fakeId = UUID.randomUUID();

        peopleResponseDto.setUuid(fakeId);
        peopleSearchCpf.setUuid(fakeId);

        Assert.assertEquals(peopleResponseDto, peopleSearchCpf);
    }
}