package dev.frankmms.selecaofamilias;

import dev.frankmms.calendario.CalendarioProvider;
import dev.frankmms.calendario.CalendarioSistema;
import dev.frankmms.utils.YamlUtils;
import dev.frankmms.selecaofamilias.model.Familia;
import dev.frankmms.selecaofamilias.model.FamiliaClassificacao;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassificadorFamiliasTest  {

    ClassificadorFamilias classificador = new ClassificadorFamilias();

    @BeforeEach
    public void init() {
        CalendarioProvider.setDefaultInstance(new CalendarioSistema(LocalDate.parse("2023-02-11")));
    }

    @Test
    @DisplayName("Dado 6 familias, quando classificar deve retornar a lista de familias ordenada com as de maior pontuacao primeiro")
    public void test1() throws IOException {
        var cenario = YamlUtils.readResource("/cenario-classificacao-com-6-familias.yaml", Cenario.class);

        var resultado = classificador.classificar(cenario.familias);

        assertThat(resultado).hasSameElementsAs(cenario.resultado);
    }

    @Data
    public static class Cenario {
        private List<Familia> familias;
        private List<FamiliaClassificacao> resultado;
    }

}
