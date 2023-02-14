package dev.frankmms.calendario;

import dev.frankmms.calendario.CalculadoraIdade;
import dev.frankmms.calendario.Calendario;
import dev.frankmms.calendario.CalendarioSistema;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraIdadeTest {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @ParameterizedTest(name = "Quando estiver em {0} e nasceu em {1}, deve ter {2} anos de idade")
    @CsvSource({
            "31/12/2009,01/01/2000,9",
            "01/01/2010,01/01/2000,10",
            "15/06/2022,10/08/1984,37",
            "31/12/2025,01/01/2000,25",
    })
    public void test(String dataAtual, String dataNascimento, int idadeEsperada) {
        Calendario calendario = new CalendarioSistema(LocalDate.parse(dataAtual, formatter));
        var calculadora = new CalculadoraIdade(calendario);

        int idadeCalculada = calculadora.calcular(LocalDate.parse(dataNascimento, formatter));

        assertEquals(idadeEsperada, idadeCalculada);
    }

}
