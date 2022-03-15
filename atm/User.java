package atm;

import java.util.*;

public class User{
    
    private String username, pin;
    private HashMap<String, Account> accounts; //accNum : account object

    public User(String username, String pin) {
        this.username = username;
        this.pin = pin;
        this.accounts = new HashMap<String, Account>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPin() {
        return this.pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void createAccount(String accNum, String type) {
        switch (type){
            case "saving":
            this.accounts.put(accNum, new SavingsAccount(accNum));
            break;
            case "current":
            this.accounts.put(accNum, new SavingsAccount(accNum));
            break;
            default:
            this.accounts.put(accNum, new SavingsAccount(accNum));
        }
    }

    public boolean accExists(String accNum) {
        return this.accounts.get(accNum) != null;
    }

    public void addTransaction(String accNum, Transaction t) {
        if (accExists(accNum)) {
            this.accounts.get(accNum).addTransaction(t);
        } else {
            this.createAccount(accNum, "saving");
            this.accounts.get(accNum).addTransaction(t);
        }
    }

    public String printTransactions(String accNum, int n) {
        if (accExists(accNum)) {
            return this.accounts.get(accNum).printTransactions(n);
        } else {
            return null;
        }
    }

}
