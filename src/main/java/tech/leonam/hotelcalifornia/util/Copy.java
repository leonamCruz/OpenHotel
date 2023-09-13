package tech.leonam.hotelcalifornia.util;

import tech.leonam.hotelcalifornia.model.dto.guest.GuestRegisterDto;
import tech.leonam.hotelcalifornia.model.dto.guest.GuestResponseDto;
import tech.leonam.hotelcalifornia.model.dto.guest.GuestUpdateDto;
import tech.leonam.hotelcalifornia.model.entity.GuestEntity;

import java.util.ArrayList;
import java.util.List;

public class Copy {
    public static GuestEntity RegisterDtoToEntity(GuestRegisterDto dto){
        var entity = new GuestEntity();
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setCellPhone(dto.getCellPhone());
        entity.setDateOfBirth(dto.getDateOfBirth());
        return entity;
    }

    public static GuestResponseDto EntityToDtoResponse(GuestEntity guest) {
        var response = new GuestResponseDto();
        response.setUuid(guest.getId());
        response.setName(guest.getName());
        response.setCpf(guest.getCpf());
        response.setCellPhone(guest.getCellPhone());
        response.setDateOfBirth(guest.getDateOfBirth());
        return response;
    }

    public static GuestEntity UpdateDtoToEntity(GuestUpdateDto guest) {
        var entity = new GuestEntity();
        entity.setId(guest.getUuid());
        entity.setCpf(guest.getCpf());
        entity.setName(guest.getName());
        entity.setCellPhone(guest.getCellPhone());
        entity.setDateOfBirth(guest.getDateOfBirth());
        return entity;
    }
    public static List<GuestResponseDto> convertListEntityToListResponseDto(List<GuestEntity> list) {
        var listResponse = new ArrayList<GuestResponseDto>();

        for (var thisTime : list) {
            listResponse.add(Copy.EntityToDtoResponse(thisTime));
        }
        return listResponse;
    }
}
