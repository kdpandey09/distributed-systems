class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(int amount) {
        if (amount <= balance) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing: " + amount);
            balance -= amount;
            System.out
                    .println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount
                    + " but insufficient balance. Current balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

class WithdrawalTask implements Runnable {
    private BankAccount account;
    private int amount;

    public WithdrawalTask(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}

public class ConcurrencyControlDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(100); // Initial balance
        Thread t1 = new Thread(new WithdrawalTask(account, 50), "Thread-1");
        Thread t2 = new Thread(new WithdrawalTask(account, 70), "Thread-2");

        t1.start();
        t2.start();
    }
}
