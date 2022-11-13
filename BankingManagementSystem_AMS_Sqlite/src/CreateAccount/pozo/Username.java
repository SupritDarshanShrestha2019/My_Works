package CreateAccount.pozo;

import CreateAccount.Service.CheckDetails.CheckUsername;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Username {
    String username;
    public Username(String username) throws FileNotFoundException {
        CheckUsername checkUsername = new CheckUsername();
        username = checkUsername.checkUsername(username);
        this.username = username;
    }
}
