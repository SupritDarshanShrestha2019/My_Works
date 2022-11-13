package AMS_Application_using_JavaFx.CreateAccount.Service.CheckDetails;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckUsername {
    public String checkUsername(String usernameVal) throws FileNotFoundException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        Scanner sc2=new Scanner(bufferedReader);
        Scanner sc=new Scanner(System.in);
        String regex="[a-zA-Z0-9_.]{5,20}";
        int count=0;
        String b="";
        while(sc2.hasNext()){
            b=sc2.next();
            if(b.equals("Username:")){
                b=sc2.next();
                if(b.equals(usernameVal)) {
                    count=1;
                }
            }
        }
        if(count==1){
            return "no";
        }
        //While testing there is an error over here we have to write two times even if we have correct regex this occurs when we write wrong regex for the first time
        if (!Pattern.matches(regex, usernameVal) ) {
            return "no";
        }
        return "yes";
    }
}
