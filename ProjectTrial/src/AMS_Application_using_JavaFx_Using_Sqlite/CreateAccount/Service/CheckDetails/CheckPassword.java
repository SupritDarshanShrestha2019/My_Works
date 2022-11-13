package AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPassword {
    public String checkPassword(String passwordVal){
        Scanner sc=new Scanner(System.in);
        String regex="[a-zA-Z0-9_.@#*&]{8,20}";
        if(Pattern.matches(regex,passwordVal)){
            return "yes";
        }else{
            return "no";
        }
    }
}
