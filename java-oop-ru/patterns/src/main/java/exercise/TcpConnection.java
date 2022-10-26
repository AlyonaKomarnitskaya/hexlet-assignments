package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;


// BEGIN
public class TcpConnection implements Connection {

    private String ip;
    private int port;

    private Connection connection;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }



    @Override
    public String getCurrentState() {
       return this.connection.getCurrentState();
    }

    @Override
    public void connect() {
        connection.connect();
    }

    @Override
    public void disconnect() {
        connection.disconnect();
    }

    public Connection getCurrentStateS(){
        return connection;
    }
    @Override
    public void write(String string) {
        this.getCurrentStateS().write(string);
    }
}
// END
