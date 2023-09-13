package tech.leonam.hotelcalifornia.util;

import tech.leonam.hotelcalifornia.model.dto.guest.GuestRegisterDto;
import tech.leonam.hotelcalifornia.model.entity.GuestEntity;

public class FakePeople {
    public static GuestRegisterDto createContactDto() {
        var dto = new GuestRegisterDto();
        dto.setName("Cruz Credo");
        dto.setCpf("714.242.940-29");
        dto.setCellPhone("91940028922");
        dto.setDateOfBirth("22/09/2000");
        return dto;
    }
    public static GuestEntity createContactEntity() {
        var dto = new GuestEntity();
        dto.setName("Cruz Credo");
        dto.setCpf("714.242.940-29");
        dto.setCellPhone("91940028922");
        dto.setDateOfBirth("22/09/2000");
        return dto;
    }
}
