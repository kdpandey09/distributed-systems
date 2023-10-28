import java.net.Socket;
import java.io.*;
import java.util.*;

public class client {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        Socket sock = new Socket("localhost", 4999);
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        OutputStream o = sock.getOutputStream();
        PrintWriter p = new PrintWriter(o, true);
        ObjectOutputStream ToServer = new ObjectOutputStream(sock.getOutputStream());
        ObjectInputStream FromServer = new ObjectInputStream(sock.getInputStream());
        String a, temp;
        System.out.println("Client Ready, Press Enter Key:");
        int CF[] = new int[14];
        while (true) {
            System.out.println("Choose Complexity(simple, average and complex):");
            temp = b.readLine();
            a = temp.toLowerCase();
            p.println(a);
            System.out.println("Enter no. of external inputs(EI):");
            a = b.readLine();
            p.println(a);
            System.out.println("Enter no. external outputs(EO):");
            a = b.readLine();
            p.println(a);
            System.out.println("Enter no. of external inquiries(EQ):");
            a = b.readLine();
            p.println(a);
            System.out.println("Enter no. of internal files(ILF):");
            a = b.readLine();
            p.println(a);
            System.out.println("Enter no of external interfaces(EIF):");
            a = b.readLine();
            p.println(a);
            System.out.println("Enter processing complexity factors:");
            for (int k = 0; k < 14; k++) {
                CF[k] = Integer.parseInt(b.readLine());
            }
            ToServer.writeObject(CF);
            String ans = (String) (FromServer.readObject());
            System.out.println(ans);
            System.out.flush();
        }
    }
}
