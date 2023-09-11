package tech.leonam.hotelcalifornia.util;

import tech.leonam.hotelcalifornia.model.dto.GuestDto;
import tech.leonam.hotelcalifornia.model.entity.GuestEntity;

public class Copy {
    public GuestEntity copyWithoutUUID(GuestDto dto){
        var entity = new GuestEntity();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setCellPhone(dto.getCellPhone());
        entity.setDateOfBirth(dto.getDateOfBirth());
        return entity;
    }
    public GuestDto copyToDto(GuestEntity entity){
        var dto = new GuestDto();
        dto.setName(entity.getName());
        dto.setCpf(entity.getCpf());
        dto.setCellPhone(entity.getCellPhone());
        dto.setDateOfBirth(entity.getDateOfBirth());
        return dto;
    }
}
