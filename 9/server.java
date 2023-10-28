import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) throws Exception {
        ServerSocket sersock = new ServerSocket(4999);
        System.out.println("Server is ready");
        Socket sock = sersock.accept();
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        OutputStream o = sock.getOutputStream();
        PrintWriter p = new PrintWriter(o, true);
        InputStream i = sock.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(i));
        String receiveMessage, sendMessage;
        while (true) {
            if ((receiveMessage = r.readLine()) != null) {
                System.out.println("Client : " + receiveMessage);
            }
            sendMessage = b.readLine();
            p.println(sendMessage);
            System.out.flush();
        }
    }
}
