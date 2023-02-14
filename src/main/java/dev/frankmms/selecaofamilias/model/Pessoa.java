package dev.frankmms.selecaofamilias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private String cpf;
    private String nome;
    private LocalDate dataNascimento;

}
