package AMS_Application_using_JavaFx.Login;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class TransactionToFile {
    public void transaction(String account,long newBalance,long oldBalance,long amount,String type) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\Transactions.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        LocalDate localDate=LocalDate.now();
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("Account: "+account+"\nDate: "+localDate+"\nType: "+type+"\nOld: "+oldBalance+"\nAmount: "+amount+"\nnew: "+newBalance+"\n");
        fileWriter.close();
    }
}
