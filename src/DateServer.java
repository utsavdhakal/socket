import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket socket = new ServerSocket(PORT)) {

            System.out.println("Server listening on port " + PORT);
            Socket client = socket.accept();
            System.out.println("Connected to a client!");

            PrintWriter writer = new PrintWriter(new BufferedOutputStream(client.getOutputStream()));

            writer.print(new Date());
            writer.flush();
            System.out.println("Response written to the client!");

            writer.close();
            client.close();
            System.out.println("Connection closed!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
