package dev.frankmms.selecaofamilias;

import com.fasterxml.jackson.core.type.TypeReference;
import dev.frankmms.calendario.CalendarioProvider;
import dev.frankmms.calendario.CalendarioSistema;
import dev.frankmms.utils.YamlUtils;
import dev.frankmms.selecaofamilias.model.Familia;
import dev.frankmms.selecaofamilias.model.FamiliaPontuacao;
import lombok.Data;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraPontosTest {

    @BeforeEach
    void init() {
        CalendarioProvider.setDefaultInstance(new CalendarioSistema(LocalDate.parse("2023-12-11")));
    }

    void test(Familia familia, FamiliaPontuacao pontuacaoEsperada) {
        var calculadora = new CalculadoraPontos();

        var pontuacaoCalculada = calculadora.calcular(familia);

        assertEquals(pontuacaoEsperada, pontuacaoCalculada);
    }

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        var cenarios = YamlUtils.readResource("/cenarios-familias-pontuacao.yaml", new TypeReference<List<Cenario>>() {});

        return cenarios.stream().map(cenario -> {
            return DynamicTest.dynamicTest(cenario.descricao, () -> test(cenario.familia, cenario.pontuacao));
        });
    }

    @Data
    public static class Cenario {
        String descricao;
        Familia familia;
        FamiliaPontuacao pontuacao;
    }

}
