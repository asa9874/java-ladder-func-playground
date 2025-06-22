package model.ladder;

import java.util.Random;

public class Connection {
    private final boolean connected;

    private Connection(boolean connected) {
        this.connected = connected;
    }

    public static Connection of(boolean previousConnected, Random random) {
        boolean connect = !previousConnected && random.nextBoolean();
        return new Connection(connect);
    }

    public boolean isConnected() {
        return connected;
    }
}
