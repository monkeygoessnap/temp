package atm;

import java.util.LinkedList;
import interfaces.Transact;

public class Account implements Transact{
    private String accNum;
    private LinkedList<Transaction> transactions;
    private long limit;
    private long balance;
    private String type;

    protected Account(String accNum) {
        this.accNum = accNum;
        this.transactions = new LinkedList<Transaction>();
        this.limit = 300000;
        this.balance = 0l;
        this.type = "default";
    }

    public String getAccNum() {
        return this.accNum;
    }

    public long getLimit() {
        return this.limit;
    }

    public long getBalance(){
        return this.balance;
    }

    public String getType() {
        return this.type;
    }

    public void setAccNum(String accNum) {
        this.accNum = accNum;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(long amount) {
        this.balance += amount;
    }

    public LinkedList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void addTransaction(Transaction t) {
        this.transactions.add(t);
        this.setBalance(t.getDeposit() - t.getWithdraw());
    }

    private String getTransactions(int n){
        String str = "\n";
        if (transactions.size() >= n ) {
            for (int i = transactions.size()-n; i < transactions.size() ; i++){
                str += transactions.get(i).toString() + "\n"; 
            }
        }
        else {
            for (int i = 0; i < transactions.size() ; i++){
                str += transactions.get(i).toString() + "\n"; 
            }
        }
        return str;
    }

    public String printTransactions(int n) {
        String str = "";
        
        str += String.format("+-------------+------------+---------+------------------------------------------------------------+------------+------------+---------------+");
        str += String.format("\n|%-13s|%-12s|%-8s|%-60s|%-12s|%-12s|%-12s|", "Date", "ValueDate", "Cheque No", "Description", "Debit", "Credit", "Running Balance");
        str += String.format("\n+-------------+------------+---------+------------------------------------------------------------+------------+------------+---------------+");
        str += (getTransactions(n));
        str += String.format("+-------------+------------+---------+------------------------------------------------------------+------------+------------+---------------+");
    
        return str;
    }
}
