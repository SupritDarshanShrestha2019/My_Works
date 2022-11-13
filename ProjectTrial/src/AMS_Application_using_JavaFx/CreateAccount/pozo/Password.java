package AMS_Application_using_JavaFx.CreateAccount.pozo;

import AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails.CheckPassword;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Password {
    public String s;
    public Password(String password){
        CheckPassword checkPassword=new CheckPassword();
        s=checkPassword.checkPassword(password);
        this.s=s;
    }
    public void storePassword(String password) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("\nPassword: "+password);
        fileWriter.close();
    }
}
