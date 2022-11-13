package CreateAccount.pozo;

import CreateAccount.Service.CheckDetails.CheckPhoneNumber;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PhoneNumber {
    String number;
    public PhoneNumber(String number){
        CheckPhoneNumber checkPhoneNumber=new CheckPhoneNumber();
        number=checkPhoneNumber.checkPhoneNumber(number);
        this.number=number;
    }
}
