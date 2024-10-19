package nineb;

public class MainNine {
    public static void main(String[] args) {
    	
        CorporateAccount companyAccount = new CorporateAccount(5000);

        Thread employee1 = new Thread(new CorporateUser(companyAccount, 1000, true));  // Credit
        Thread employee2 = new Thread(new CorporateUser(companyAccount, 500, false));  // Debit
        Thread employee3 = new Thread(new CorporateUser(companyAccount, 2000, true));  // Credit
        Thread employee4 = new Thread(new CorporateUser(companyAccount, 800, false));  // Debit
        Thread employee5 = new Thread(new CorporateUser(companyAccount, 3000, false)); // Debit

        employee1.start();
        employee2.start();
        employee3.start();
        employee4.start();
        employee5.start();
        
        try {
            employee1.join();
            employee2.join();
            employee3.join();
            employee4.join();
            employee5.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        companyAccount.getTotalBalance();}}
