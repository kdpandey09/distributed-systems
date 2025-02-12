import java.util.Scanner;

public class DeadlockDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] process = new int[10][15];
        int siteCount = 0, processCount = 0, blockedProcess = 0, temp = 0;
        int[] waiting = new int[15]; // Waiting array for the processes

        // Input the number of sites
        System.out.print("Enter the number of sites (max 3): ");
        siteCount = scanner.nextInt();

        // Input the processes for each site
        for (int i = 1; i <= siteCount; i++) {
            System.out.print("Enter the number of processes in site " + i + " (max 4): ");
            processCount = scanner.nextInt();

            for (int j = 0; j < processCount; j++) {
                process[i][j] = i + (i * j); // Initialize process identifiers
            }
        }

        // Input the blocked process
        System.out.print("Enter the blocked process: ");
        blockedProcess = scanner.nextInt();

        // Deadlock detection logic
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (blockedProcess == process[i][j]) {
                    System.out.println("Process " + blockedProcess + " is at site " + i);
                    temp = i; // Store the site of the blocked process
                }

                // Check for deadlock
                if (blockedProcess == process[i][j]) {
                    System.out.println("It is a deadlock.");
                }

                if (blockedProcess == process[temp][j] &&
                        process[temp][j] == waiting[process[i][j]] &&
                        temp != i) {
                    System.out.println("It is a deadlock.");
                }
            }
        }

        scanner.close();
    }
}
