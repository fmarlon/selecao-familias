package dev.frankmms.calendario;

import java.time.LocalDate;

public interface Calendario {

    static Calendario getInstance() {
        return CalendarioProvider.getDefaultInstance();
    }

    LocalDate dataAtual();

}
