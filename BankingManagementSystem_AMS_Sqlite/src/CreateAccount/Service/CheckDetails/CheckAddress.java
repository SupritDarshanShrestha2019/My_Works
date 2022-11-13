package CreateAccount.Service.CheckDetails;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckAddress {
    public String checkAddress(String addressVal){
        Scanner sc=new Scanner(System.in);
        String regex="([a-zA-Z0-9-,]+ ?)+";
        while(!Pattern.matches(regex,addressVal)){
            System.out.print("Error enter address again: ");
            addressVal=sc.nextLine();
        }
        return addressVal;
    }
}
