package AMS_Application_using_JavaFx.CreateAccount.pozo;

import AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails.CheckUsername;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Username {
    public String s;
    public Username(String username) throws FileNotFoundException {
        CheckUsername checkUsername=new CheckUsername();
        s=checkUsername.checkUsername(username);
        this.s=s;
    }
    public void storeUsername(String username) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("Username: "+username);
        fileWriter.close();
    }
}
