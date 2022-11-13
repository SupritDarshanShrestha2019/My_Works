package AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.pozo;

import AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails.CheckPhoneNumber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneNumber {
    public String s;
    public PhoneNumber(String number){
        CheckPhoneNumber checkPhoneNumber=new CheckPhoneNumber();
        s=checkPhoneNumber.checkPhoneNumber(number);
        this.s=s;
    }
    public void storeNumber(String number) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("\nPhoneNumber: "+number+"\n");
        fileWriter.close();
    }
}
