import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class client {
 public static void main(String args[]) throws IOException {
	Socket s = new Socket("localhost" , 4999);
	PrintWriter pr = new PrintWriter(s.getOutputStream());
	pr.println("Is it working ?");
	pr.flush();
	InputStreamReader in1 = new InputStreamReader(s.getInputStream());
    BufferedReader bf = new BufferedReader(in1);
    String str = bf.readLine();
    System.out.println("Server");
    System.out.println(str);
 }
}
