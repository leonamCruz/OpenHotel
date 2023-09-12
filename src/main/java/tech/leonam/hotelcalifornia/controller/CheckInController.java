package tech.leonam.hotelcalifornia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.leonam.hotelcalifornia.model.entity.CheckInEntity;
import tech.leonam.hotelcalifornia.service.CheckInService;

@RestController
@CrossOrigin(origins = "*", maxAge = 30)
@RequestMapping("/check")
public class CheckInController {
    private final CheckInService service;
    public CheckInController(CheckInService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<Object> registerCheckIn(@RequestBody CheckInEntity checkInEntity){
        service.register(checkInEntity);
        return ResponseEntity.ok().build();
    }
    
}
