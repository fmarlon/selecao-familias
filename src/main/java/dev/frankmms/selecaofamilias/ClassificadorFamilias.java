package dev.frankmms.selecaofamilias;

import dev.frankmms.selecaofamilias.model.Familia;
import dev.frankmms.selecaofamilias.model.FamiliaClassificacao;
import dev.frankmms.selecaofamilias.model.FamiliaPontuacao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@NoArgsConstructor
public class ClassificadorFamilias {
    
    private CalculadoraPontos calculadoraPontos = new CalculadoraPontos();
    
    public List<FamiliaClassificacao> classificar(List<Familia> familias) {
        var familiasPontuacao = calcularPontuacao(familias);

        ordernarPorPontuacao(familiasPontuacao);

        return mapearParaFamiliasClassificacao(familiasPontuacao);
    }

    private void ordernarPorPontuacao(List<FamiliaPontuacao> familiasPontuacao) {
        familiasPontuacao.sort(Comparator.comparing(FamiliaPontuacao::getPontos).reversed());
    }

    private List<FamiliaPontuacao> calcularPontuacao(List<Familia> familias) {
        var familiasPontuacao = familias.stream()
                .map(calculadoraPontos::calcular)
                .collect(Collectors.toList());
        return familiasPontuacao;
    }

    private List<FamiliaClassificacao> mapearParaFamiliasClassificacao(List<FamiliaPontuacao> familiasPontuacao) {
        return IntStream.rangeClosed(1, familiasPontuacao.size())
                .mapToObj(posicao -> new FamiliaClassificacao(familiasPontuacao.get(posicao - 1), posicao))
                .collect(Collectors.toList());
    }

}
