package CreateAccount.pozo;

import CreateAccount.Service.CheckDetails.CheckEmail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Email {
    String email;
    public Email(String email){
        CheckEmail checkEmail=new CheckEmail();
        email=checkEmail.checkEmail(email);
        this.email=email;
    }

}
