package atm;

public class CurrentAccount extends Account {
    private long overdraftLimit = 300000;

    public CurrentAccount(String accNum) {
        super(accNum);
        this.setType("current");
    }
    
    public long getOverdraftLimit(){
        return -this.overdraftLimit;
    }

    public long setOverdraftLimit(long limit){
        this.overdraftLimit = -limit;
        return -this.overdraftLimit;
    }


}
