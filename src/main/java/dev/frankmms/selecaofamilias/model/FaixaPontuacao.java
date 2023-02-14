package dev.frankmms.selecaofamilias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FaixaPontuacao {

    private Integer valorInicial;
    private Integer valorFinal;
    private Integer qtdPontos;

    public boolean englobaValor(Integer valorFaixa) {
        return valorFaixa >= valorInicial && valorFaixa <= valorFinal;
    }

}
