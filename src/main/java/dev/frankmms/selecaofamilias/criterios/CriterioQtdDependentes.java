package dev.frankmms.selecaofamilias.criterios;

import dev.frankmms.calendario.CalculadoraIdade;
import dev.frankmms.calendario.Calendario;
import dev.frankmms.selecaofamilias.*;
import dev.frankmms.selecaofamilias.model.FaixaPontuacao;
import dev.frankmms.selecaofamilias.model.Familia;

import java.util.List;

public class CriterioQtdDependentes implements CriterioPontuacao {

    private CalculadoraIdade calculadoraIdade = new CalculadoraIdade(Calendario.getInstance());
    private int idadeLimite = 18;

    private LocalizadorFaixa localizadorFaixa;

    public CriterioQtdDependentes() {
        /**
         * - Famílias com 3 ou mais dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 3 pontos;
         * - Famílias com 1 ou 2 dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 2 pontos.
         */
        this(List.of(
                new FaixaPontuacao(3, Integer.MAX_VALUE, 3),
                new FaixaPontuacao(1, 2, 2)
        ));
    }

    public CriterioQtdDependentes(List<FaixaPontuacao> faixas) {
        this.localizadorFaixa = new LocalizadorFaixa(faixas);
    }

    @Override
    public int calcular(Familia familia) {
        int qtdDependentesValidos = (int)familia.getDependentes().stream()
                .filter(it -> calculadoraIdade.calcular(it.getDataNascimento()) <= idadeLimite)
                .count();

        int pontos = localizadorFaixa.buscarPontos(qtdDependentesValidos);

        return pontos;
    }

}
