package AMS_Application_using_JavaFx.CreateAccount.pozo;

import AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails.CheckEmail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Email {
    public String s;
    public Email(String email){
        CheckEmail checkEmail=new CheckEmail();
        s=checkEmail.checkEmail(email);
        this.s=s;
    }
    public void storeEmail(String email) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("\nEmail: "+email);
        fileWriter.close();
    }
}
