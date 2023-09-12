package tech.leonam.hotelcalifornia.service;

import org.springframework.stereotype.Service;
import tech.leonam.hotelcalifornia.model.entity.CheckInEntity;
import tech.leonam.hotelcalifornia.repository.CheckInRepository;

import java.util.List;
import java.util.UUID;
@Service
public class CheckInService {
    private final CheckInRepository repository;

    public CheckInService(CheckInRepository repository) {
        this.repository = repository;
    }

    public void register(CheckInEntity entity) {
        repository.save(entity);
    }
    public void delete(UUID uuid){
        repository.deleteById(uuid);
    }
    public void modify(){
        //TODO
    }
    public List<CheckInEntity> getAll(){
        return repository.findAll();
    }
}
