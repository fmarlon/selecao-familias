package dev.frankmms.selecaofamilias;

import dev.frankmms.selecaofamilias.criterios.CriterioQtdDependentes;
import dev.frankmms.selecaofamilias.criterios.CriterioRendaFamiliar;
import dev.frankmms.selecaofamilias.model.Familia;
import dev.frankmms.selecaofamilias.model.FamiliaPontuacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
public class CalculadoraPontos {

    private Map<String, CriterioPontuacao> criterios = Map.of(
            "RENDA_FAMILIAR", new CriterioRendaFamiliar(),
            "QTD_DEPENDENTES", new CriterioQtdDependentes()
    );

    public FamiliaPontuacao calcular(Familia familia) {
        var pontuacao = new FamiliaPontuacao(familia);

        pontuacao.calcular(criterios);

        return pontuacao;
    }

}
