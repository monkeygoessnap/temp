package atm;

public class SavingsAccount extends Account {

    public SavingsAccount(String accNum) {
        super(accNum);
        this.setType("savings");
    }

}
