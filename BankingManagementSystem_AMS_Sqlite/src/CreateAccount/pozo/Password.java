package CreateAccount.pozo;

import CreateAccount.Service.CheckDetails.CheckPassword;
import CreateAccount.Service.CheckDetails.CheckUsername;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Password {
    String password;
    public Password(String password){
        CheckPassword checkPassword=new CheckPassword();
        password=checkPassword.checkPassword(password);
        this.password=password;
    }
}
