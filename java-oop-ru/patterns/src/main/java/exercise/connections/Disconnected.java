package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        TcpConnection c = this.tcpConnection;
        c.setConnection(new Connected(c));
        System.out.println("connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Disconnection already connected");
    }

    @Override
    public void write(String string) {
        System.out.println("Error " + string);
    }
}
// END
