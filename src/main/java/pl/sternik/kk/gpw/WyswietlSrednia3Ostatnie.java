package pl.sternik.kk.gpw;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class WyswietlSrednia3Ostatnie implements Observer {

	private final Map<String, LinkedList<Double>> ostatnieTiki = new HashMap<String, LinkedList<Double>>();
	private static final int LAST_TICKS_NO = 3;

	@Override
	public void update(Observable o, Object arg) {

		Tik tik = (Tik) arg;
		int ileWartosciTika = 0;
		double sredniaostatnie = 0;

		if (ostatnieTiki.containsKey(tik.getNazwa())) {
			LinkedList<Double> wartosciTika = ostatnieTiki.get(tik.getNazwa());
			ileWartosciTika = wartosciTika.size();
			if (ileWartosciTika == LAST_TICKS_NO) {
				wartosciTika.removeFirst();
			}
			wartosciTika.addLast(tik.getCena());
			ileWartosciTika = wartosciTika.size();
			sredniaostatnie = wyliczSrednia(wartosciTika);
			System.out.println("ŚR:Spółka: " + tik.getNazwa() + " średnia z " + wartosciTika.size() + " ostatnich: "
					+ sredniaostatnie);
		}
		else{
			LinkedList<Double> values = new LinkedList<Double>();
			ostatnieTiki.put(tik.getNazwa(), values);
			values.add(tik.getCena());
		}
	}

	private double wyliczSrednia(LinkedList<Double> listaWartosci) {
		double suma = 0;
		double wynik = 0;

		for (Double cena : listaWartosci) {
			suma = suma + cena;
		}
		wynik = suma / listaWartosci.size();
		return wynik;
	}
}