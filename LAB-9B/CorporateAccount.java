package nineb;

class CorporateAccount {
    private double totalBalance;

    public CorporateAccount(double initialBalance) {
        this.totalBalance = initialBalance;
        System.out.println("Corporate Account created with initial balance: " + initialBalance);
    }

    public synchronized void credit(double amount) {
        if (amount > 0) {
            System.out.println("Crediting account with amount: " + amount);
            totalBalance += amount;
            System.out.println("New balance after credit: " + totalBalance);
        } else {
            System.out.println("Credit amount must be positive");
        }
    }
    
    public synchronized void debit(double amount) {
        if (amount > 0 && amount <= totalBalance) {
            System.out.println("Debiting account with amount: " + amount);
            totalBalance -= amount;
            System.out.println("New balance after debit: " + totalBalance);
        } else if (amount > totalBalance) {
            System.out.println("Insufficient funds for debit of: " + amount);
        } else {
            System.out.println("Debit amount must be positive");
        }
    }

    public synchronized double getTotalBalance() {
        System.out.println("Checking current total balance: " + totalBalance);
        return totalBalance;
    }
}
