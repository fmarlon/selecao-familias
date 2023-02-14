package dev.frankmms.selecaofamilias;

import dev.frankmms.selecaofamilias.model.FaixaPontuacao;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class LocalizadorFaixa {

    private List<FaixaPontuacao> faixas;

    public Integer buscarPontos(Integer valorFaixa) {
        return buscarPorValor(valorFaixa)
                .map(FaixaPontuacao::getQtdPontos)
                .orElse(0);
    }

    public Optional<FaixaPontuacao> buscarPorValor(Integer valorFaixa) {
        return faixas.stream()
                .filter(it -> it.englobaValor(valorFaixa))
                .findFirst();
    }

}
