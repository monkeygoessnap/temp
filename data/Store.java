package data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;
import java.io.File;
import atm.User;
import atm.Transaction;

public class Store {
    
    private final ConcurrentHashMap<String, User> userStore;

    public Store() {
        this.userStore = new ConcurrentHashMap<String, User>();
    }

    public boolean loadData(String path) {
        try {
            Scanner scan = new Scanner(new File(path));
            //skips header
            scan.nextLine();
            //iterate line by line
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Scanner scanLine = new Scanner(line);
                scanLine.useDelimiter(",");
                String accNum = scanLine.next();
                String date = scanLine.next();
                String description = scanLine.next();
                String chequeNum = scanLine.next();
                String valueDate = scanLine.next();
                long wAmt = 0, dAmt = 0;
                try {
                    wAmt =  (long)(Double.parseDouble(scanLine.next())*100);
                } catch (Exception e) {
                    //do nothing
                }
                try {
                    dAmt = (long)(Double.parseDouble(scanLine.next())*100);
                } catch (Exception e) {
                    //do nothing
                }
                //skips balance amt
                scanLine.next();
                //close line scanner
                scanLine.close();
                long balance = 0;
                Transaction newT = new Transaction (date, valueDate, chequeNum, description, wAmt, dAmt, balance-wAmt+dAmt);
                String username = "default";

                //for testing, all same user
                if (getUser(username) == null) {
                    User newUser = createUser();
                    newUser.addTransaction(accNum, newT);
                    userStore.put(newUser.getUsername(), newUser);
                } else {
                    userStore.get(username).addTransaction(accNum, newT);
                }
            }
            //close file scanner
            scan.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public User createUser() {
        //default the username and pin
        //TODO: need to change
        String username = "default";
        String pin = "123";
        return new User(username, pin);
    }

    public User getUser(String username) {
        return userStore.get(username);
    }

    //public void writeTransaction(Transaction t) {

    //}

}
