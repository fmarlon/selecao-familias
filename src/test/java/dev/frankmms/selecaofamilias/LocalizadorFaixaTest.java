package dev.frankmms.selecaofamilias;

import dev.frankmms.selecaofamilias.model.FaixaPontuacao;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocalizadorFaixaTest {

    @Test
    public void faixasRendaFamiliar() {
        /**
         * - Renda total da família até 900 reais - valendo 5 pontos;
         * - Renda total da família de 901 à 1500 reais - valendo 3 pontos;
         */
        var faixas = new LocalizadorFaixa(List.of(
                new FaixaPontuacao(0, 900, 5),
                new FaixaPontuacao(901, 1500, 3)
        ));

        assertEquals(5, faixas.buscarPontos(0));
        assertEquals(5, faixas.buscarPontos(100));
        assertEquals(5, faixas.buscarPontos(400));
        assertEquals(5, faixas.buscarPontos(900));
        assertEquals(3, faixas.buscarPontos(901));
        assertEquals(3, faixas.buscarPontos(950));
        assertEquals(3, faixas.buscarPontos(1000));
        assertEquals(3, faixas.buscarPontos(1500));
        assertEquals(0, faixas.buscarPontos(1501));
        assertEquals(0, faixas.buscarPontos(1600));
    }

    @Test
    public void faixasQtdDependentes() {
        /**
         * - Famílias com 3 ou mais dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 3 pontos;
         * - Famílias com 1 ou 2 dependentes  (lembrando que dependentes maiores de 18 anos não contam) - valendo 2 pontos.
         */
        var faixas = new LocalizadorFaixa(List.of(
                new FaixaPontuacao(3, Integer.MAX_VALUE, 3),
                new FaixaPontuacao(1, 2, 2)
        ));

        assertEquals(0, faixas.buscarPontos(0));
        assertEquals(2, faixas.buscarPontos(1));
        assertEquals(2, faixas.buscarPontos(2));
        assertEquals(3, faixas.buscarPontos(3));
        assertEquals(3, faixas.buscarPontos(4));
        assertEquals(3, faixas.buscarPontos(5));
        assertEquals(3, faixas.buscarPontos(10));
        assertEquals(3, faixas.buscarPontos(40));
    }

}
