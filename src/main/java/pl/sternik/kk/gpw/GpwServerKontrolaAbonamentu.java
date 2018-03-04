package pl.sternik.kk.gpw;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public final class GpwServerKontrolaAbonamentu extends Observable implements Observer, ServerDanychGieldowych {
    private final ServerDanychGieldowych gpwServer;
    private final Set<String> tikiOplacone = new HashSet<String>();

    public GpwServerKontrolaAbonamentu(ServerDanychGieldowych server, String shareName) {
        this.gpwServer = server;
        server.addObserver(this);
        tikiOplacone.add(shareName);
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
