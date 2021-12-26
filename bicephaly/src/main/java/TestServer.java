import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9225);
        InputStreamReader inputStreamReader;
        try {
            while (true) {
                Socket socket = serverSocket.accept();
//                inputStreamReader =
//                        new InputStreamReader(socket.getInputStream());
                PrintWriter writer = new PrintWriter(socket.getOutputStream()
                        , true);
//                BufferedReader br = new BufferedReader(inputStreamReader);
//                String message = br.readLine();
//                System.out.println(message);
//                br.close();
//            writer.flush();
                writer.println("Yo! Got it");
                writer.close();
                System.out.println("Sent Message");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
