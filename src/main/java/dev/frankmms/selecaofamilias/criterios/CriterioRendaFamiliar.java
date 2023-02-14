package dev.frankmms.selecaofamilias.criterios;

import dev.frankmms.selecaofamilias.CriterioPontuacao;
import dev.frankmms.selecaofamilias.LocalizadorFaixa;
import dev.frankmms.selecaofamilias.model.FaixaPontuacao;
import dev.frankmms.selecaofamilias.model.Familia;

import java.util.List;

public class CriterioRendaFamiliar implements CriterioPontuacao {

    private LocalizadorFaixa localizadorFaixa;

    /**
     * - Renda total da família até 900 reais - valendo 5 pontos;
     * - Renda total da família de 901 à 1500 reais - valendo 3 pontos;
     */
    public CriterioRendaFamiliar() {
        this(List.of(
                new FaixaPontuacao(0, 900, 5),
                new FaixaPontuacao(901, 1500, 3)
        ));
    }

    public CriterioRendaFamiliar(List<FaixaPontuacao> faixas) {
        this.localizadorFaixa = new LocalizadorFaixa(faixas);
    }

    @Override
    public int calcular(Familia familia) {
        return localizadorFaixa.buscarPontos(familia.getRenda().intValue());
    }
}
