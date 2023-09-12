package tech.leonam.hotelcalifornia.util;

import tech.leonam.hotelcalifornia.model.dto.GuestRegisterDto;
import tech.leonam.hotelcalifornia.model.dto.GuestResponseDto;
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
        var dto = new GuestResponseDto();
        dto.setUuid(guest.getId());
        dto.setName(guest.getName());
        dto.setCpf(guest.getCpf());
        dto.setCellPhone(guest.getCellPhone());
        dto.setDateOfBirth(guest.getDateOfBirth());
        return dto;
    }
}
