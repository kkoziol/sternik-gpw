package pl.sternik.kk.gpw;

import java.util.Iterator;

public class TikGenerator implements Iterable<Tik> {
	
	private int numberOfTicksToGenerate = 0;
	private String tickName;

	public TikGenerator(String tickName, int numberOfTicksToGenerate) {
		super();
		this.tickName = tickName;
		this.numberOfTicksToGenerate = numberOfTicksToGenerate;
	}

	public Iterator<Tik> iterator() {

		return new Iterator<Tik>() {
			int current = 0;

			public Tik next() {
				current++;
				return new Tik(tickName, Math.random() * 100);
			}

			public boolean hasNext() {
				return current < numberOfTicksToGenerate;
			}
		};
	}

	public static void main(String[] args) {

		TikGenerator c = new TikGenerator("Bogdanka", 5);
		for (Tik tik : c) {
			System.out.println(tik);
		}
		
	}
}
