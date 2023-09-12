package tech.leonam.hotelcalifornia.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.leonam.hotelcalifornia.model.dto.GuestDto;
import tech.leonam.hotelcalifornia.service.GuestService;
import tech.leonam.hotelcalifornia.util.Copy;
import tech.leonam.hotelcalifornia.util.CpfFormat;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 30)
@RequestMapping("/guest")
public class GuestController {
    private final GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> registerGuest(@RequestBody @Valid GuestDto guest){
        service.register(new Copy().copyWithoutUUID(guest));
        ResponseEntity.status(HttpStatus.OK);
        return ResponseEntity.ok().build();
    }
    @PutMapping("{uuid}")
    public ResponseEntity<Object> modifyGuest(@PathVariable UUID uuid,@RequestBody @Valid GuestDto guest){
        if (!service.existsById(uuid)){
            return ResponseEntity.badRequest().build();
        }

        service.modify(new Copy().copyWithUUID(guest));
        return ResponseEntity.accepted().build();
    }
    @DeleteMapping("{uuid}")
    public ResponseEntity<Object> deleteGuest(@PathVariable UUID uuid){
        if(!service.existsById(uuid)){
            return ResponseEntity.badRequest().build();
        }
        service.delete(uuid);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/all")
    public ResponseEntity<Object> getAllGuests(){
        return ResponseEntity.ok().body(service.getAll());
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getByName(@PathVariable String name){
        return ResponseEntity.ok().body(service.getByName(name));
    }
    @GetMapping("/document/{cpf}")
    public ResponseEntity<Object> getByDocument(@PathVariable String cpf){
        return ResponseEntity.ok().body(service.getByDocument(CpfFormat.format(cpf)));
    }
    @GetMapping("/cellphone/{cellPhone}")
    public ResponseEntity<Object> getByCellPhone(@PathVariable String cellPhone){
        return ResponseEntity.ok().body(service.getByCellPhone(cellPhone));
    }
}
