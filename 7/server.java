import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args[]) throws IOException {
        ServerSocket sersock = new ServerSocket(4999);
        System.out.println("Server ready");
        System.out.println("Waiting for a client ...");
        Socket sock = sersock.accept();
        System.out.println("Client accepted");
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        OutputStream o = sock.getOutputStream();
        PrintWriter p = new PrintWriter(o, true);
        InputStream i = sock.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(i));
        String send, rec, fun, s1, s2, s3;
        while (true) {
            fun = r.readLine();
            if (fun != null) {
                System.out.println("Operation:" + fun);
            }
            s1 = r.readLine();
            System.out.println("String1:" + s1);
            s2 = r.readLine();
            System.out.println("String2:" + s2);
            if (fun.compareTo("concat") == 0) {
                s3 = s1 + s2;
                System.out.println("String after concatenation is:" + s3);
                p.println("String after concatenation is:" + s3);
            }
            if (fun.compareTo("len") == 0) {
                System.out.println("Length of first string is:" + s1.length());
                p.println("Length of first string is :" + s1.length());
                System.out.println("Length of second string is:" + s2.length());
                p.println("Length of first string is:" + s2.length());
            }
            if (fun.compareTo("compare") == 0) {
                System.out.println("Are the strings same:" + (s1.equals(s2)));
                p.println("Are the strings same:" + (s1.equals(s2)));
            }
            if (fun.compareTo("copy") == 0) {
                s2 = s1;
                System.out.println("First String:" + s1);
                p.println("First String :" + s1);
                System.out.println("Second string after copy:" + s2);
                p.println("Second string sfter copy:" + s2);
            }
                System.out.flush();
        }
    }
}
