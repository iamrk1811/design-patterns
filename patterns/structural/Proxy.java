package patterns.structural;

/*
 * Proxy: provides a placeholder or intermediary object to control access to another object
 */

interface Account {
    public void showBalance();
    public void withdrawBalance(int amount);
}

class BankAccount implements Account {
    @Override
    public void showBalance() {
        
    }

    @Override
    public void withdrawBalance(int amount) {
        
    }
}

// ATM is a proxy to BankAccount, so access can be control from here
class ATM implements Account {
    private BankAccount bankAccount;

    ATM() {
        this.bankAccount = new BankAccount();
    }

    @Override
    public void showBalance() {
        this.bankAccount.showBalance();        
    }

    @Override
    public void withdrawBalance(int amount) {
        this.bankAccount.withdrawBalance(amount);
    }
}

class ClientProxy {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.showBalance();
    }
}