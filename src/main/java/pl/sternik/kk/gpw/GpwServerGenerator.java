package pl.sternik.kk.gpw;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public final class GpwServerGenerator extends Observable implements ServerDanychGieldowych {

    private final List<Iterator<Tik>> generatory;

    public GpwServerGenerator() {
        generatory = new ArrayList<>();
        generatory.add(new TikGenerator("KGH", 10).iterator());
        generatory.add(new TikGenerator("WWL", 10).iterator());
        generatory.add(new TikGenerator("PKO", 10).iterator());
        generatory.add(new TikGenerator("PKN", 10).iterator());
        generatory.add(new TikGenerator("ATN", 10).iterator());
    }

    @Override
    public void symulujTransakcje() {
        setChanged();
        Tik tik = pobierzTik();
        if (tik != null) {
            notifyObservers(tik);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Tik pobierzTik() {
        int r = (int) ((Math.random() * generatory.size()) % generatory.size());
        if (generatory.get(r).hasNext()) {
            return generatory.get(r).next();
        } else {
            for (Iterator<Tik> iterator : generatory) {
                if (iterator.hasNext()) {
                    return iterator.next();
                }
            }
        }
        return null;
    }

//    private Tik pobierzTik() {
//        for (Iterator<Tik> iterator : generatory) {
//            if (iterator.hasNext()) {
//                return iterator.next();
//            }
//        }
//        return null;
//    }

}
