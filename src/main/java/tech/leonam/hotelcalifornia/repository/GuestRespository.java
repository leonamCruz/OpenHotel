    package tech.leonam.hotelcalifornia.repository;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import org.springframework.data.repository.query.Param;
    import org.springframework.stereotype.Repository;
    import tech.leonam.hotelcalifornia.model.entity.GuestEntity;

    import java.util.List;
    import java.util.UUID;
    @Repository
    public interface GuestRespository extends JpaRepository<GuestEntity, UUID> {
        @Query("SELECT g FROM GuestEntity g WHERE g.name LIKE %:name%")
        List<GuestEntity> findByName(@Param("name") String name);

        @Query("SELECT g FROM GuestEntity g WHERE g.cpf = :cpf")
        List<GuestEntity> findByDocument(@Param("cpf") String cpf);

        @Query("SELECT g FROM GuestEntity g WHERE g.cellPhone = :cellPhone")
        List<GuestEntity> findByCellPhone(@Param("cellPhone") String cellPhone);

    }
