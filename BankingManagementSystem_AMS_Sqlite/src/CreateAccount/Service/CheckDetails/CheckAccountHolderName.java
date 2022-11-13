package CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckAccountHolderName {
    public String checkName(String name){
        Scanner sc=new Scanner(System.in);
        String regex="([a-zA-Z]+ ?)+";
        while(!Pattern.matches(regex,name)){
            System.out.print("Error enter name again: ");
            name=sc.nextLine();
        }
        return name;
    }
}
