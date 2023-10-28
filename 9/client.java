import java.io.*;
import java.net.*;

public class client{
    public static void main(String[] args) throws Exception {
        Socket sock = new Socket("localhost", 4999);
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        OutputStream o = sock.getOutputStream();
        PrintWriter p = new PrintWriter(o, true);
        InputStream i = sock.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(i));
        System.out.println("Start the conversation,type and press Enter");
        String receiveMessage, sendMessage;
        while (true) {

            sendMessage = b.readLine();
            p.println(sendMessage);
            System.out.flush();
            if ((receiveMessage = r.readLine()) != null) {
                System.out.println("Server : " + receiveMessage);
            }
        }
    }
}
