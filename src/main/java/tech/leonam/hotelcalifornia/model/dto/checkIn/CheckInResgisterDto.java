package tech.leonam.hotelcalifornia.model.dto.checkIn;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class CheckInResgisterDto {
    @NotBlank
    @Setter
    public UUID guestUuid;
    @NotBlank
    public String momentEntry;
    @NotBlank
    public String momentExit;
    @NotNull
    @Setter
    public boolean additionalCar;

    public void setMomentEntry(String momentEntry) {
        verifyDate();
        verifyHour();
        this.momentEntry = momentEntry;
    }

    private void verifyHour() {

    }

    private void verifyDate() {
        //dateInvalid();
    }

    public void setMomentExit(String momentExit){
        verifyDate();
        verifyHour();
        this.momentExit = momentExit;
    }

}
