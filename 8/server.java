import java.util.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Math.*;

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
        String fun, s1;
        double d, rad, res;
        while (true) {
            fun = r.readLine();
            if (fun != null) {
                System.out.println("Function:" + fun);
            }
            s1 = r.readLine();
            System.out.println("Value in Degrees:" + s1);
            d = Double.parseDouble(s1);
            rad = Math.toRadians(d);
            System.out.println("Value in Radians :" + rad);
            if (fun.compareTo("sin") == 0) {
                res = Math.sin(rad);
                System.out.println("Sin is:" + res);
                p.println("Sin is :" + res);
            }
            if (fun.compareTo("cos") == 0) {
                res = Math.cos(rad);
                System.out.println("Cos is :" + res);
                p.println("Cos is :" + res);
            }
            if (fun.compareTo("tan") == 0) {
                if (d != 90.0) {
                    res = Math.tan(rad);
                    System.out.println("Tan is :" + res);
                    p.println("Tan is :" + res);

                } else {
                    System.out.println("Tan not defined.");
                    p.println("Tan not defined");
                }
            }
            if (fun.compareTo("cot") == 0) {
                if (d != 0.0) {
                    res = 1 / Math.tan(rad);
                    System.out.println("Cot is :" + res);
                    p.println("Cot is :" + res);
                } else {
                    System.out.println("Cot not defined");
                    p.println("Cot not defined.");
                }
            }
            if (fun.compareTo("sec") == 0) {
                if (d != 90.0) {
                    res = 1 / Math.cos(rad);
                    System.out.println("Sec is :" + res);
                    p.println("Sec is :" + res);
                } else {
                    System.out.println("Sec not defined.");
                    p.println("Sec not defined");
                }
            }
            if (fun.compareTo("cosec") == 0) {
                if (d != 0.0) {
                    res = 1 / Math.sin(rad);
                    System.out.println("Cosec is :" + res);
                    p.println("Cosec is :" + res);
                } else {
                    System.out.println("Cosec not defined");
                    p.println("Cosec not defined");
                }
            }
            System.out.flush();
        }
    }
}
