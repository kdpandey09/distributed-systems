import java.util.Scanner;

class Process {
    int e; // Number of events
    int[] ts = new int[10]; // Timestamp array
}

public class LamportClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Process[] p = new Process[10];
        int n, m, t, e1, e2;
        char ch;

        // Input number of processes
        System.out.print("Enter the number of processes: ");
        n = scanner.nextInt();

        // Initialize processes and their events
        for (int i = 0; i < n; i++) {
            p[i] = new Process();
            System.out.print("Enter the number of events in process " + (i + 1) + ": ");
            p[i].e = scanner.nextInt();
            for (int j = 0; j < p[i].e; j++) {
                p[i].ts[j] = j + 1; // Initialize timestamps
            }
        }

        // Display initial timestamps
        System.out.println("\nInitial timestamps:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p[i].e; j++) {
                System.out.print(p[i].ts[j] + " ");
            }
            System.out.println();
        }

        // Handle message passing
        do {
            System.out.print("\nEnter the process number and event number from which the message is passing (less than "
                    + n + "): ");
            m = scanner.nextInt() - 1;
            e1 = scanner.nextInt() - 1;

            System.out.print("Enter the process number and event number to which the message is passing (less than " + n
                    + "): ");
            t = scanner.nextInt() - 1;
            e2 = scanner.nextInt() - 1;

            if ((p[m].ts[e1] + 1) > p[t].ts[e2]) {
                p[t].ts[e2] = p[m].ts[e1] + 1;

                // Update subsequent timestamps
                for (int i = e2; i < p[t].e - 1; i++) {
                    p[t].ts[i + 1] = p[t].ts[i] + 1;

                }
            }

            System.out.print("Is there more message passing? (y/n): ");
            ch = scanner.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');

        // Display final timestamps
        System.out.println("\nFinal timestamps:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p[i].e; j++) {
                System.out.print(p[i].ts[j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
