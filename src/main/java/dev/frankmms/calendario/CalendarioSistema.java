package dev.frankmms.calendario;

import java.time.*;

/**
 * Classe necessário para encapsular as chamadas da data/hora corrente,
 * no cálculo de idade de uma pessoa, por exemplo.
 * Nos testes que possuem cálculos que dependem da variável tempo,
 * define-se a data do sistema para que as verificações do teste funcionem corretamente.
 */
public class CalendarioSistema implements Calendario {

    private Clock clock = Clock.systemDefaultZone();

    public CalendarioSistema() {
        super();
    }

    public CalendarioSistema(LocalDate dataCorrente) {
        var zonedDateTime = ZonedDateTime.now();
        Instant fixedInstant = dataCorrente.atTime(zonedDateTime.toLocalTime()).toInstant(zonedDateTime.getOffset());
        clock = Clock.fixed(fixedInstant, zonedDateTime.getZone());
    }

    public LocalDate dataAtual() {
        return LocalDate.now(clock);
    }

}
