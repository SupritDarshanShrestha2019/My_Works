package AMS_Application_using_JavaFx.CreateAccount.pozo;

import AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails.CheckAccountNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AccountNumber {
    public String no;
    public AccountNumber(String no) throws FileNotFoundException {
        CheckAccountNumber checkAccountNumber=new CheckAccountNumber();
        no=checkAccountNumber.checkAccountNumber(no);
        this.no=no;
    }
    public void storeAccNumber(String account) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("\nAccountNumber: "+account);
        fileWriter.close();
    }
}
