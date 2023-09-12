package tech.leonam.hotelcalifornia.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.leonam.hotelcalifornia.model.entity.GuestEntity;
import tech.leonam.hotelcalifornia.repository.GuestRespository;

import java.util.List;
import java.util.UUID;

@Service
public class GuestService {
    private final GuestRespository respository;

    public GuestService(GuestRespository respository) {
        this.respository = respository;
    }

    @Transactional
    public void register(GuestEntity guest) {
        respository.save(guest);
    }

    @Transactional
    public void delete(UUID uuid) {
        respository.deleteById(uuid);
    }

    @Transactional
    public void modify(GuestEntity guest) {
        //TODO
    }
    public boolean existsById(UUID uuid){
        return respository.existsById(uuid);
    }
    public List<GuestEntity> getAll(){
        return respository.findAll();
    }
    public List<GuestEntity> getByName(String name){
        return respository.findByName(name);
    }

    public List<GuestEntity> getByDocument(String cpf) {
        return respository.findByDocument(cpf);
    }
    public List<GuestEntity> getByCellPhone(String cellPhone){
        return respository.findByCellPhone(cellPhone);
    }
}
