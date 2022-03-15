import data.*;
import atm.*;

public class Main {
    public static void main(String[] args) {
        String path = "data\\bank_sample_01.csv";
        Store newStore = new Store();
        System.out.println("Load Data: " + newStore.loadData(path));
        User newUser = newStore.getUser("default");
        System.out.println(newUser.printTransactions("409000611074'", 10));
        System.out.println("----------------------------------------------");
        System.out.println(newUser.printTransactions("1196428'", 10));
    }
}
