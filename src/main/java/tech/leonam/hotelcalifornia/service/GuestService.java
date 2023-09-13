package tech.leonam.hotelcalifornia.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.leonam.hotelcalifornia.model.dto.GuestRegisterDto;
import tech.leonam.hotelcalifornia.model.dto.GuestResponseDto;
import tech.leonam.hotelcalifornia.model.dto.GuestUpdateDto;
import tech.leonam.hotelcalifornia.model.entity.GuestEntity;
import tech.leonam.hotelcalifornia.repository.GuestRespository;
import tech.leonam.hotelcalifornia.util.Copy;
import tech.leonam.hotelcalifornia.util.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

@Service
public class GuestService {
    private final GuestRespository respository;

    public GuestService(GuestRespository respository) {
        this.respository = respository;
    }

    @Transactional
    public GuestResponseDto register(GuestRegisterDto guest) {
        var entity = Copy.RegisterDtoToEntity(guest);
        var response = respository.save(entity);
        return Copy.EntityToDtoResponse(response);
    }

    @Transactional
    public void delete(UUID uuid) throws NotFoundException {
        verifyIfNotExists(uuid);
        respository.deleteById(uuid);
    }

    @Transactional
    public GuestResponseDto modify(GuestUpdateDto guest) throws NotFoundException {
        verifyIfNotExists(guest.getUuid());
        var entity = Copy.UpdateDtoToEntity(guest);
        var entitySaved = respository.save(entity);
        return Copy.EntityToDtoResponse(entitySaved);
    }
    private void verifyIfNotExists(UUID uuid) throws NotFoundException {
        if (!existsById(uuid)) {
            throw new NotFoundException("This id was not found.");
        }
    }
    public List<GuestEntity> getAll() {
        return respository.findAll();
    }

    public List<GuestEntity> getByName(String name) {
        return respository.findByName(name);
    }

    public List<GuestEntity> getByDocument(String cpf) {
        return respository.findByDocument(cpf);
    }

    public List<GuestEntity> getByCellPhone(String cellPhone) {
        return respository.findByCellPhone(cellPhone);
    }

    private boolean existsById(UUID uuid) {
        return respository.existsById(uuid);
    }
}
