package AMS_Application_using_JavaFx.CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPhoneNumber {
    public String checkPhoneNumber(String phoneNumberVal){
        int count=0;
        String regex="(\\+977)[0-9]{10}";
        String regex2="(977)[0-9]{10}";
        String regex3="([0-9]{10})";
        if(Pattern.matches(regex,phoneNumberVal)){
            count=1;
        }else if(Pattern.matches(regex2,phoneNumberVal)){
            count=1;
        }else if(Pattern.matches(regex3,phoneNumberVal)){
            count=1;
        }
        if(count==1){
            return "yes";
        }else{
            return "no";
        }
    }
}
