package pl.sternik.kk.gpw;

public final class PanelTradera {

	private static ServerDanychGieldowych GPW_SERVER = new GpwServer();

	private final WyswietlaczTikow wyswietlaczTikow = new WyswietlaczTikow();

	private static final int ILE_POZYCJI = 51;

	private PanelTradera(ServerDanychGieldowych server) {
	    server.addObserver(wyswietlaczTikow);
	}

	public static void main(String[] args) {

		new PanelTradera(PanelTradera.GPW_SERVER);


		for (int i = 0; i < ILE_POZYCJI; i++) {
			PanelTradera.GPW_SERVER.symulujTransakcje();
		}

	}
}
