package tech.leonam.hotelcalifornia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.leonam.hotelcalifornia.model.entity.GuestEntity;

import java.util.UUID;
@Repository
public interface GuestRespository extends JpaRepository<GuestEntity, UUID> {
}
