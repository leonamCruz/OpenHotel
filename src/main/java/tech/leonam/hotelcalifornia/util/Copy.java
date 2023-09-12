package tech.leonam.hotelcalifornia.util;

import tech.leonam.hotelcalifornia.model.dto.GuestRegisterDto;
import tech.leonam.hotelcalifornia.model.dto.GuestResponseDto;
import tech.leonam.hotelcalifornia.model.dto.GuestUpdateDto;
import tech.leonam.hotelcalifornia.model.entity.GuestEntity;

public class Copy {
    public GuestEntity RegisterDtoToEntity(GuestRegisterDto dto){
        var entity = new GuestEntity();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setCellPhone(dto.getCellPhone());
        entity.setDateOfBirth(dto.getDateOfBirth());
        return entity;
    }

    public GuestResponseDto EntityToDtoResponse(GuestEntity guest) {
        var response = new GuestResponseDto();
        response.setUuid(guest.getId());
        response.setName(guest.getName());
        response.setCpf(guest.getCpf());
        response.setCellPhone(guest.getCellPhone());
        response.setDateOfBirth(guest.getDateOfBirth());
        return response;
    }

    public GuestEntity UpdateDtoToEntity(GuestUpdateDto guest) {
        var entity = new GuestEntity();
        entity.setId(guest.getUuid());
        entity.setCpf(guest.getCpf());
        entity.setName(guest.getName());
        entity.setCellPhone(guest.getCellPhone());
        entity.setDateOfBirth(guest.getDateOfBirth());
        return entity;
    }
}
