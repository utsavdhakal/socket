import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket server = new Socket(SERVER_IP, SERVER_PORT)) {

            Scanner scanner = new Scanner(new BufferedInputStream(server.getInputStream()));
            System.out.println(scanner.nextLine());

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
