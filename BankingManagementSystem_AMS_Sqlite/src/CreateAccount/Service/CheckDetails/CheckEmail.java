package CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckEmail {
    public String checkEmail(String emailVal){
        Scanner sc=new Scanner(System.in);
        String regex="\\w+@[a-zA-Z]+.[a-zA-Z]+";
        while(!Pattern.matches(regex,emailVal)){
            System.out.print("Error enter email again: ");
            emailVal=sc.next();
        }
        return emailVal;
    }
}
