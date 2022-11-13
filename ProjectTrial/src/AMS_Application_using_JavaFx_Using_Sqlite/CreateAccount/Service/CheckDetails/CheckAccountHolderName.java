package AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckAccountHolderName {
    public String checkName(String name){
        Scanner sc=new Scanner(System.in);
        String regex="([a-zA-Z]+ ?)+";
        if(Pattern.matches(regex,name)){
            return "yes";
        }else{
            return "no";
        }
    }
}
