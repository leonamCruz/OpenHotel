package tech.leonam.hotelcalifornia.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class CheckInEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    @OneToOne
    public GuestEntity guest;
    @Column
    public String momentEntry;
    @Column
    public String momentExit;
    @Column
    public boolean additionalCar;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public GuestEntity getGuest() {
        return guest;
    }

    public void setGuest(GuestEntity guest) {
        this.guest = guest;
    }

    public String getMomentEntry() {
        return momentEntry;
    }

    public void setMomentEntry(String momentEntry) {
        this.momentEntry = momentEntry;
    }

    public String getMomentExit() {
        return momentExit;
    }

    public void setMomentExit(String momentExit) {
        this.momentExit = momentExit;
    }

    public boolean isAdditionalCar() {
        return additionalCar;
    }

    public void setAdditionalCar(boolean additionalCar) {
        this.additionalCar = additionalCar;
    }
}
