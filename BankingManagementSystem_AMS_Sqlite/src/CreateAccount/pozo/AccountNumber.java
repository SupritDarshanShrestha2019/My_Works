package CreateAccount.pozo;

import CreateAccount.Service.CheckDetails.CheckAccountNumber;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AccountNumber {
    String no;
    public AccountNumber(String no) throws FileNotFoundException {
        CheckAccountNumber checkAccountNumber=new CheckAccountNumber();
        no=checkAccountNumber.checkAccountNumber(no);
        this.no=no;
    }
}
