package tech.leonam.hotelcalifornia.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@Entity
public class CheckInEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @ManyToOne
    @JoinColumn(name = "guest_id")
    public GuestEntity guest;
    @Column(name = "moment_entry")
    public String momentEntry;
    @Column(name = "moment_exit")
    public String momentExit;
    @Column(name = "additional_car")
    public boolean additionalCar;
}
