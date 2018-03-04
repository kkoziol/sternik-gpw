package pl.sternik.kk.gpw;

public final class PanelTradera {

    private static ServerDanychGieldowych GPW_SERVER = new GpwServer();
    private static ServerDanychGieldowych PROXY_ABONAMENT_KGH = new GpwServerKontrolaAbonamentu(GPW_SERVER, "KGH");
    private static ServerDanychGieldowych PROXY_ABONAMENT_PKO = new GpwServerKontrolaAbonamentu(GPW_SERVER, "PKO");

    private final WyswietlaczTikow wyswietlaczTikow = new WyswietlaczTikow();
    private final WyswietlProcentZmiany wyswietlProcentZmiany = new WyswietlProcentZmiany();
    private final WyswietlSrednia3Ostatnie wyswietlSrednia3Ostatnie = new WyswietlSrednia3Ostatnie();
    private static final int ILE_POZYCJI = 51;

    private PanelTradera(ServerDanychGieldowych server) {
        server.addObserver(wyswietlaczTikow);
        server.addObserver(wyswietlProcentZmiany);
        server.addObserver(wyswietlSrednia3Ostatnie);
    }

    public static void main(String[] args) {

        new PanelTradera(PanelTradera.PROXY_ABONAMENT_KGH);
        new PanelTradera(PanelTradera.PROXY_ABONAMENT_PKO);
        for (int i = 0; i < ILE_POZYCJI; i++) {
            // PanelTradera.GPW_SERVER.symulujTransakcje();
            // A dlaczego to tak działa tez dla PKO?
            PanelTradera.PROXY_ABONAMENT_KGH.symulujTransakcje();
        }

    }
}
