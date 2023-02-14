package dev.frankmms.selecaofamilias;

import dev.frankmms.selecaofamilias.model.Familia;
import dev.frankmms.selecaofamilias.model.FamiliaClassificacao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class ClassificadorFamilias {
    private CalculadoraPontos calculadoraPontos = new CalculadoraPontos();
    public List<FamiliaClassificacao> classificar(List<Familia> familias) {
        List<FamiliaClassificacao> familiasPontuacao = calcularPontuacao(familias);

        ordernarPorPontuacao(familiasPontuacao);
        definirPosicao(familiasPontuacao);

        return familiasPontuacao;
    }

    private void ordernarPorPontuacao(List<FamiliaClassificacao> familiasPontuacao) {
        familiasPontuacao.sort(Comparator.comparing(it -> -it.getPontuacao().getPontos()));
    }

    private List<FamiliaClassificacao> calcularPontuacao(List<Familia> familias) {
        var familiasPontuacao = familias.stream()
                .map(familia -> {
                    var pontuacao = calculadoraPontos.calcular(familia);

                    return new FamiliaClassificacao(pontuacao, 0);
                })
                .collect(Collectors.toList());
        return familiasPontuacao;
    }

    private void definirPosicao(List<FamiliaClassificacao> familiasPontuacao) {
        for (int i = 0; i < familiasPontuacao.size(); i++) {
            familiasPontuacao.get(i).setPosicao(i + 1);
        }
    }

}
