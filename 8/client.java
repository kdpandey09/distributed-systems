import java.util.*;
import java.net.Socket;
import java.io.*;

public class client {
    public static void main(String args[]) throws IOException {
        Socket sock = new Socket("localhost", 4999);
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        OutputStream o = sock.getOutputStream();
        PrintWriter p = new PrintWriter(o, true);
        InputStream i = sock.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(i));
        String a, fun, temp;
        System.out.println("Client Ready, Press Enter Key :");
        while (true) {
            System.out.println("Choose Function(sin,cos,tan,cot,sec,cosec) ");
            temp = b.readLine();
            a = temp.toLowerCase();
            p.println(a);
            System.out.println("Enter degrees :");
            a = b.readLine();
            p.println(a);
            System.out.flush();
        }
    }
}
