package AMS_Application_using_JavaFx.CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckEmail {
    public String checkEmail(String emailVal){
        Scanner sc=new Scanner(System.in);
        String regex="\\w+@[a-zA-Z]+.[a-zA-Z]+";
        if(Pattern.matches(regex,emailVal)){
            return "yes";
        }else {
            return "no";
        }
    }
}
