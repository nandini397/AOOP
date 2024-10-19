package nineb;

class CorporateUser implements Runnable {
    private CorporateAccount account;
    private double amount;
    private boolean isCredit;

    public CorporateUser(CorporateAccount account, double amount, boolean isCredit) {
        this.account = account;
        this.amount = amount;
        this.isCredit = isCredit;
    }

    @Override
    public void run() {
        if (isCredit) {
            account.credit(amount);
        } else {
            account.debit(amount);
        }
    }
}
