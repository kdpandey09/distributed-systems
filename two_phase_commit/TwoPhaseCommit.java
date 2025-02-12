import java.util.ArrayList;
import java.util.List;

public class TwoPhaseCommit {

    public static void main(String[] args) {
        Coordinator coordinator = new Coordinator();
        List<Participant> participants = new ArrayList<>();

        // Add participants
        participants.add(new Participant("Participant 1"));
        participants.add(new Participant("Participant 2"));

        // Execute the 2PC protocol
        coordinator.executeTransaction(participants);
    }
}

class Coordinator {
    public void executeTransaction(List<Participant> participants) {
        // Phase 1: Prepare
        boolean canCommit = true;
        for (Participant participant : participants) {
            if (!participant.prepare()) {
                canCommit = false;
                break;
            }
        }

        // Phase 2: Commit or Rollback
        if (canCommit) {
            for (Participant participant : participants) {
                participant.commit();
            }
            System.out.println("Transaction committed successfully.");
        } else {
            for (Participant participant : participants) {
                participant.rollback();
            }
            System.out.println("Transaction aborted.");
        }
    }
}

class Participant {
    private String name;

    public Participant(String name) {
        this.name = name;
    }

    public boolean prepare() {
        // Simulate prepare phase
        System.out.println(name + " is preparing...");
        // In a real implementation, check if the participant can commit
        return true; // Assuming success for simplicity
    }

    public void commit() {
        System.out.println(name + " is committing...");
    }

    public void rollback() {
        System.out.println(name + " is rolling back...");
    }
}
