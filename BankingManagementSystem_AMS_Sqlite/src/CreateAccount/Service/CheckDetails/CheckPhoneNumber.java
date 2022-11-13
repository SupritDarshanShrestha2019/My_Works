package CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPhoneNumber {
    public String checkPhoneNumber(String phoneNumberVal){
        Scanner sc=new Scanner(System.in);
        String regex="((\\+977)[0-9]{10})||((977)[0-9]{10})||[0-9]{10}";
        while(!Pattern.matches(regex,phoneNumberVal)){
            System.out.print("Error enter phone number again: ");
            phoneNumberVal=sc.next();
        }
        return phoneNumberVal;
    }
}
