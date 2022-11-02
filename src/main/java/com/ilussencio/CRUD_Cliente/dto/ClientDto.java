package com.ilussencio.CRUD_Cliente.dto;

import com.ilussencio.CRUD_Cliente.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    public ClientDto(Client entity){
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        income = entity.getIncome();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }
}
