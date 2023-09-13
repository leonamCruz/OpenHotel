package tech.leonam.hotelcalifornia.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.leonam.hotelcalifornia.model.dto.GuestRegisterDto;
import tech.leonam.hotelcalifornia.model.dto.GuestResponseDto;
import tech.leonam.hotelcalifornia.model.dto.GuestUpdateDto;
import tech.leonam.hotelcalifornia.service.GuestService;
import tech.leonam.hotelcalifornia.util.CpfFormat;
import tech.leonam.hotelcalifornia.util.exception.DocumentException;
import tech.leonam.hotelcalifornia.util.exception.NotFoundException;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 30)
@RequestMapping("/guests")
public class GuestController {
    private final GuestService service;

    public GuestController(GuestService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<GuestResponseDto> registerGuest(@RequestBody @Valid GuestRegisterDto guest){
        var entitySaved = service.register(guest);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entitySaved.getUuid()).toUri();
        return ResponseEntity.created(uri).body(entitySaved);
    }
    @PutMapping
    public ResponseEntity<Object> modifyGuest(@RequestBody @Valid GuestUpdateDto guest) throws NotFoundException {
        var entityUpdated = service.modify(guest);
        return ResponseEntity.ok().body(entityUpdated);
    }
    @DeleteMapping("{uuid}")
    public void deleteGuest(@PathVariable UUID uuid) throws NotFoundException {
        service.delete(uuid);
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
    public ResponseEntity<Object> getByDocument(@PathVariable String cpf) throws DocumentException {
        return ResponseEntity.ok().body(service.getByDocument(CpfFormat.format(cpf)));
    }
    @GetMapping("/cellphone/{cellPhone}")
    public ResponseEntity<Object> getByCellPhone(@PathVariable String cellPhone){
        return ResponseEntity.ok().body(service.getByCellPhone(cellPhone));
    }
}
