import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.*;

public class client{
 public static void main(String args[]) throws IOException {
	Socket s = new Socket("localhost" , 4999);
PrintWriter pr = new PrintWriter(s.getOutputStream());
	pr.println("hello");
	pr.flush();
 }
}
