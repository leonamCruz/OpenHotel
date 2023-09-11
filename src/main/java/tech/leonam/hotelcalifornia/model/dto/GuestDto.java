package tech.leonam.hotelcalifornia.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public class GuestDto {
    @NotBlank
    @Min(value = 3, message = "Name: The minimum number of characters is 3")
    @Max(value = 255, message = "Name: The maximum number of characters is 255")
    private String name;
    @NotBlank
    @CPF(message = "Cpf: Invalid")
    private String cpf;
    @NotBlank
    @Max(value = 15, message = "Cellphone: Maximum characters are 15")
    @Min(value = 8, message = "Cellphone: Minimum characters are 8")
    private String cellPhone;
    @NotBlank
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$", message = "Date of Birth: Invalid")
    private String dateOfBirth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
