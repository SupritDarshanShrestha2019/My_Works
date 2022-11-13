package AMS_Application_using_JavaFx.CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckAddress {
    public String checkAddress(String addressVal){
        Scanner sc=new Scanner(System.in);
        String regex="([a-zA-Z0-9-,]+ ?)+";
        if(Pattern.matches(regex,addressVal)){
            return "yes";
        }else{
            return "no";
        }
    }
}
