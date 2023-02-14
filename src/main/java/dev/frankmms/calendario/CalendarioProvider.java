package dev.frankmms.calendario;

public class CalendarioProvider {

    private static Calendario defaultInstance = new CalendarioSistema();

    public static Calendario getDefaultInstance() {
        return defaultInstance;
    }

    public static void setDefaultInstance(Calendario defaultInstance) {
        CalendarioProvider.defaultInstance = defaultInstance;
    }
}
