import java.util.Scanner;

public class LockingMechanism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0; // Lock status: 0 (unlocked), 1 (locked)
        char b, c;

        do {
            // Transaction T1 attempts to lock the data object
            System.out.print("If transaction T1 wants to lock the data object (y/n): ");
            b = scanner.next().charAt(0);

            if (a == 0 && b == 'y') {
                a = 1; // Lock the data object
                b = 'n'; // Reset input
            } else if (a == 1) {
                System.out.println("Data object is locked.");
            }

            // Transaction T2 attempts to lock the data object
            System.out.print("If transaction T2 wants to lock the data object (y/n): ");
            b = scanner.next().charAt(0);

            if (a == 0 && b == 'y') {
                a = 1; // Lock the data object
                b = 'n'; // Reset input
            } else {
                System.out.println("Data object is locked.");
            }

            // Transaction attempts to release the data object
            System.out.print("\nIf a transaction wants to release the data object (y/n): ");
            b = scanner.next().charAt(0);

            if (a == 1 && b == 'y') {
                a = 0; // Unlock the data object
            }

            // Ask if the user wants to continue
            System.out.print("Do you want to continue (y/n): ");
            c = scanner.next().charAt(0);
        } while (c == 'y');

        scanner.close();
    }
}
