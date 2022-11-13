package AMS_Application_using_JavaFx.CreateAccount.pozo;

import AMS_Application_using_JavaFx.CreateAccount.Service.CheckDetails.CheckAddress;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Address {
    public String s;
    public Address(String address){
        CheckAddress checkAddress=new CheckAddress();
        s=checkAddress.checkAddress(address);
        this.s=s;
    }
    public void storeAddress(String addressVal) throws IOException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        FileWriter fileWriter=new FileWriter(file,true);
        fileWriter.write("\nAddress: "+addressVal);
        fileWriter.close();
    }
}
