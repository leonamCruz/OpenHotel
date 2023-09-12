package tech.leonam.hotelcalifornia.model.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class GuestRegisterDto {
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
