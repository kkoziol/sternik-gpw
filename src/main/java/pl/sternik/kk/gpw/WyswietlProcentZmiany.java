package pl.sternik.kk.gpw;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class WyswietlProcentZmiany implements Observer {

	private final Map<String, Tik> lastTiks = new HashMap<String, Tik>();

	@Override
	public void update(Observable o, Object arg) {
		Tik tik = (Tik) arg;
		Tik tikOld = lastTiks.get(tik.getNazwa());
		if (tikOld != null) {
			double zmiana = ((tik.getCena() - tikOld.getCena()) / tikOld.getCena()) * 100;
			System.out.println("PZ:Spółka: " + tik.getNazwa() + " zmiana: " + zmiana + "%");
		}
		lastTiks.put(tik.getNazwa(), tik);
	}
}