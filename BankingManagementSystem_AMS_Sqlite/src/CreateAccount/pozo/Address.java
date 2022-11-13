package CreateAccount.pozo;

import CreateAccount.Service.CheckDetails.CheckAddress;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Address {
    String address;
    public Address(String address){
        CheckAddress checkAddress=new CheckAddress();
        address=checkAddress.checkAddress(address);
        this.address=address;
    }
}
