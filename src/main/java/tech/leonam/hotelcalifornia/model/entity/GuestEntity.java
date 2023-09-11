package tech.leonam.hotelcalifornia.model.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String name;
    @Column
    private String cpf;
    @Column
    private String cellPhone;
    @Column
    private String dateOfBirth;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
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

    public void setCellPhone(String telefone) {
        this.cellPhone = telefone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dataDeNascimento) {
        this.dateOfBirth = dataDeNascimento;
    }
}
