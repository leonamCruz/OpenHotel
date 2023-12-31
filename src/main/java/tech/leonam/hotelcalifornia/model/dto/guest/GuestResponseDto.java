package tech.leonam.hotelcalifornia.model.dto.guest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Getter
@Setter
public class GuestResponseDto {
    private UUID uuid;
    @NotBlank
    @Size(min = 3, max = 255, message = "Name: The minimum number of characters is 3 and the maximum is 255")
    private String name;
    @NotBlank
    @CPF(message = "Cpf: Invalid")
    private String cpf;
    @NotBlank
    @Size(min = 7, max = 15, message = "Cellphone: The minimum number of characters is 7 and the maximum is 15")
    private String cellPhone;
    @NotBlank
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "Date of Birth: Invalid")
    private String dateOfBirth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuestResponseDto that = (GuestResponseDto) o;

        if (!uuid.equals(that.uuid)) return false;
        if (!name.equals(that.name)) return false;
        if (!cpf.equals(that.cpf)) return false;
        if (!cellPhone.equals(that.cellPhone)) return false;
        return dateOfBirth.equals(that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + cellPhone.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GuestResponseDto{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
