package CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckPassword {
    public String checkPassword(String passwordVal){
        Scanner sc=new Scanner(System.in);
        String regex="[a-zA-Z0-9_.@#*&]{8,20}";
        while(!Pattern.matches(regex,passwordVal)){
            System.out.print("Error enter password again: ");
            passwordVal=sc.nextLine();
        }
        return passwordVal;
    }
}
