import java.io.*;
import java.util.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        ServerSocket sersock = new ServerSocket(4999);
        System.out.println("Server ready");
        System.out.println("Waiting for a client ...");
        Socket sock = sersock.accept();
        System.out.println("Client accepted");
        InputStream i = sock.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(i));
        ObjectInputStream FromClient = new ObjectInputStream(sock.getInputStream());
        ObjectOutputStream ToClient = new ObjectOutputStream(sock.getOutputStream());
        String fun, i1, i2, i3, i4, i5;
        int sim[] = new int[] { 3, 4, 3, 7, 5 },
                avg[] = new int[] { 4, 5, 4, 10, 7 },
                comp[] = new int[] { 6, 7, 6, 15, 10 };
        while (true) {
            fun = r.readLine();
            if (fun != null) {
                System.out.println("Complexity:" + fun);
            }
            i1 = r.readLine();
            int ei = Integer.parseInt(i1);
            System.out.println("No. of EI:" + ei);
            i2 = r.readLine();
            int eo = Integer.parseInt(i2);
            System.out.println("No. of EO:" + eo);
            i3 = r.readLine();
            int eq = Integer.parseInt(i3);
            System.out.println("No. of EQ:" + eq);
            i4 = r.readLine();
            int ilf = Integer.parseInt(i4);
            System.out.println("No. of ILF:" + ilf);
            i5 = r.readLine();
            int elf = Integer.parseInt(i5);
            System.out.println("No. of ELF:" + elf);
            System.out.println("Complexity Factors:");
            int CF[] = (int[]) FromClient.readObject();
            for (int k = 0; k < 14; k++)

            {
                System.out.print(CF[k] + " ");
            }
            System.out.println();
            int index = 0;
            String result = "Functional Point (FP):";
            int sum = 0;
            for (int k = 0; k < 14; k++) {
                sum = sum + CF[k];
            }
            if (fun.compareTo("simple") == 0) {
                index = 0;
                int sum_simple = sum;
                int count_total = ei * sim[index] + eo * sim[index + 1] + eq * sim[index + 2] + ilf * sim[index + 3]
                        + elf
                                * sim[index + 4];
                double FP = count_total * (0.65 + 0.01 * sum_simple);
                result += Double.toString(FP);
            } else if (fun.compareTo("average") == 0) {
                index = 0;
                int sum_average = sum;
                int count_total = ei * avg[index] + eo * avg[index + 1] + eq * avg[index + 2] + ilf * avg[index + 3]
                        + elf
                                * avg[index + 4];
                double FP = count_total * (0.65 + 0.01 * sum_average);
                result += Double.toString(FP);
            } else if (fun.compareTo("complex") == 0) {
                index = 0;
                int sum_complex = sum;
                int count_total = ei * comp[index] + eo * comp[index + 1] + eq * comp[index + 2] + ilf *
                        comp[index + 3] + elf * comp[index + 4];
                double FP = count_total * (0.65 + 0.01 * sum_complex);
                result += Double.toString(FP);
            } else {
                result += "Wrong Input";
            }
            System.out.println(result);
            ToClient.writeObject(result);
            System.out.flush();
        }
    }
}