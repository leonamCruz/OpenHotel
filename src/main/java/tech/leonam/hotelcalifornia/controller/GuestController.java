package tech.leonam.hotelcalifornia.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.leonam.hotelcalifornia.model.dto.GuestDto;
import tech.leonam.hotelcalifornia.model.entity.GuestEntity;
import tech.leonam.hotelcalifornia.service.GuestService;
import tech.leonam.hotelcalifornia.util.Copy;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 30)
@RequestMapping("/guest")
public class GuestController {
    private final GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerGuest(@RequestBody @Valid GuestDto guest){
        service.register(new Copy().copyWithoutUUID(guest));
        return ResponseEntity.ok().body(HttpStatus.CREATED);
    }
    @PostMapping("/modify")
    @Valid
    public ResponseEntity<Object> modifyGuest(@RequestBody GuestEntity guest){
        var dto = new Copy().copyToDto(guest);
        return ResponseEntity.accepted().body(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deleteGuest(@RequestBody UUID uuid){
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
