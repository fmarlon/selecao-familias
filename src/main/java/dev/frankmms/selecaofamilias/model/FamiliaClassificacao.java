package dev.frankmms.selecaofamilias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamiliaClassificacao {

    private FamiliaPontuacao pontuacao;

    private Integer posicao;

    public Familia getFamilia() {
        return pontuacao == null ? null : pontuacao.getFamilia();
    }

}
