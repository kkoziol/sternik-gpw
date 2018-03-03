package pl.sternik.kk.gpw;

import java.util.Observer;

public interface ServerDanychGieldowych {
    void addObserver(Observer o);

    void symulujTransakcje();
}
