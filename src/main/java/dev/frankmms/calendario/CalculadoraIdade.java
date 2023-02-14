package dev.frankmms.calendario;

import dev.frankmms.calendario.Calendario;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
public class CalculadoraIdade {

    private Calendario calendario;

    public int calcular(LocalDate dataNascimento) {
        var dataAtual = calendario.dataAtual();
        var period = Period.between(dataNascimento, dataAtual);

        return period.getYears();
    }

}
