package dev.frankmms.selecaofamilias.model;

import dev.frankmms.selecaofamilias.CriterioPontuacao;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Data
@NoArgsConstructor
public class FamiliaPontuacao {

    private Familia familia;
    private Integer pontos = 0;
    private Map<String, Integer> pontosPorCriterio = new LinkedHashMap<>();

    public FamiliaPontuacao(Familia familia) {
        this.familia = familia;
    }

    public void calcular(Map<String, CriterioPontuacao> criterios) {
        criterios.forEach((nome, criterio) -> {
            int pontos = criterio.calcular(familia);

            this.pontosPorCriterio.put(nome, pontos);
            this.pontos += pontos;
        });
    }

    @Override
    public String toString() {
        return String.format(
                "FamiliaPontuacao(familia(id=%s), pontos=%s, pontosPorCriterio=%s)",
                familia == null ? null : familia.getId(), pontos, pontosPorCriterio
        );
    }

}
