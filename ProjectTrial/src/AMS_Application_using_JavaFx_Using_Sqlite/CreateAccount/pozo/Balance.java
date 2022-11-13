package AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.pozo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Balance {
    long balance;
    public Balance(long balance){
        this.balance=balance;
    }
    public void storeBalance(String balances) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("\nBalance: " + balances);
        fileWriter.close();
    }
}
