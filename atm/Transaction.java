package atm;

public class Transaction {
    private String date;
    private String valueDate;
    private String chequeNum;
    private String description;
    private long withdraw;
    private long deposit;
    private long balance;

    public Transaction(String date, String valueDate, String chequeNum, String description, long withdraw, long deposit, long balance) {
        this.date = date;
        this.valueDate = valueDate;
        this.chequeNum = chequeNum;
        this.description = description;
        this.withdraw = withdraw;
        this.deposit = deposit;
        this.balance = balance;
    }

    public String getTransactionDate() {
        return this.date;
    }

    public String getValueDate() {
        return this.valueDate;
    }

    public String getChequeNum() {
        return this.chequeNum;
    }

    public String getDescription() {
        return this.description;
    }

    public long getWithdraw() {
        return this.withdraw;
    }

    public long getDeposit() {
        return this.deposit;
    }

    public long getBalance() {
        return this.balance;
    }

    @Override
    public String toString(){
        //String s = String.format("|%1$td/%1$tm/%1$tY   |%2$td/%2$tm/%2$tY   |%3$-9s|%4$-60s|%5$12.2f|%6$12.2f|%7$15.2f|", this.transactionDate, this.valueDate, this.chequeNo, this.description, (float)this.withdraw/100, (float)this.deposit/100, (float)this.runningBalance/100);
        String s = String.format("|%1$s   |%2$s  |%3$-9s|%4$-60s|%5$12.2f|%6$12.2f|%7$15.2f|", this.date, this.valueDate, this.chequeNum, this.description, (double)this.withdraw/100, (double)this.deposit/100, (double)this.balance/100);

        return s;
    }

}
