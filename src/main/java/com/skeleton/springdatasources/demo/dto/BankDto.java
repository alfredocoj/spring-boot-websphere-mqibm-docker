package com.skeleton.springdatasources.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankDto implements Serializable {

    private Long id;

    @NotNull(message = "Nome do Banco é uma informação obrigatória")
    @Length(min = 3, max = 40, message = "O nome do banco deve estar entre 3 e 40 caracteres")
    private String name;

    @NotNull(message = "Endereço do Banco é uma informação obrigatória")
    @Length(min = 5, max = 70, message = "O endereço do banco deve estar entre 3 e 40 caracteres")
    private String address;

    @Override
    public String toString() {
        return "BankDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
