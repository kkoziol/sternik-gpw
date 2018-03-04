package pl.sternik.kk.gpw;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public final class GpwServerKontrolaAbonamentu extends Observable implements Observer, ServerDanychGieldowych {
    private final ServerDanychGieldowych gpwServer;
    private final Set<String> tikiOplacone = new HashSet<String>();

    public GpwServerKontrolaAbonamentu(ServerDanychGieldowych server) {
        this.gpwServer = server;
        server.addObserver(this);
        tikiOplacone.add("KGH");
//        tikiOplacone.add("WWL");
//        tikiOplacone.add("PKO");
    }

    @Override
    public void update(Observable o, Object arg) {
        Tik tik = (Tik) arg;
        if (tikiOplacone.contains(tik.getNazwa())) {
            setChanged();
            notifyObservers(tik);
        }
    }

    @Override
    public void symulujTransakcje() {
        gpwServer.symulujTransakcje();
    }
}
