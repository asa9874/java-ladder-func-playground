package model.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Floor {
        private final List<Connection> connections;

        public Floor(int width,Random random) {
            connections = new ArrayList<>();
            boolean previousConnection = false;
            for (int i = 0; i < width-1; i++) {
                Connection connection =Connection.of(previousConnection,random);
                connections.add(connection);
                previousConnection = connection.isConnected();
            }
        }

        public List<Connection> getConnections() {
            return connections;
        }
}
