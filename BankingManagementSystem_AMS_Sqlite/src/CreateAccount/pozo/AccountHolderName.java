package CreateAccount.pozo;

import CreateAccount.Service.CheckDetails.CheckAccountHolderName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AccountHolderName {
    String name;
    public AccountHolderName(String name){
        CheckAccountHolderName checkAccountHolderName=new CheckAccountHolderName();
        name=checkAccountHolderName.checkName(name);
        this.name=name;
    }
}
