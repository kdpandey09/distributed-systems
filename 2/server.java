import java.io.*;
import java.net.*;
import java.util.*;

public class server {
 public static void main(String args[]) throws IOException {
ServerSocket ss = new ServerSocket(4999);
    Socket s = ss.accept();
    System.out.println("Client Connected !");
    InputStreamReader in1 = new InputStreamReader(s.getInputStream());
    BufferedReader bf = new BufferedReader(in1);
    String str = bf.readLine();
    System.out.println("Client");
    System.out.println(str); 
}
}
