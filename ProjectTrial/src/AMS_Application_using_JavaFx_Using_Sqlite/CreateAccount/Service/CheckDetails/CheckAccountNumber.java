package AMS_Application_using_JavaFx_Using_Sqlite.CreateAccount.Service.CheckDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckAccountNumber {
    public String checkAccountNumber(String accountNumberVal) throws FileNotFoundException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        Scanner sc2=new Scanner(bufferedReader);
        Scanner sc=new Scanner(System.in);
        String regex="[0-9]{12}";
        Random random = new Random();
        int count=0;
        String b="";
        while(sc2.hasNext()){
            b=sc2.next();
            if(b.equals("AccountNumber:")){
                b=sc2.next();
                if(b.equals(accountNumberVal)) {
                    count=1;
                }
            }
        }
        if(!Pattern.matches(regex,accountNumberVal) || count==1){
            accountNumberVal=Long.toString(Math.round(random.nextFloat() * Math.pow(10,12)));
            checkAccountNumber(accountNumberVal);
        }
        return accountNumberVal;
    }
}
