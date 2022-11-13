package AMS_Application_using_JavaFx.CreateAccount.pozo;

import AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails.CheckAccountHolderName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AccountHolderName {
    public String s;
    public AccountHolderName(String name){
        CheckAccountHolderName checkAccountHolderName=new CheckAccountHolderName();
        s=checkAccountHolderName.checkName(name);
        this.s=s;
    }
    public void storeName(String name) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("\nName: "+name);
        fileWriter.close();
    }
}
