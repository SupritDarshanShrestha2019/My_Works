package AMS_Application_using_JavaFx.Login.Loggedin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ViewTransactions {
    public void viewTransactions(String account) throws FileNotFoundException {
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\Transactions.txt");
        FileReader fileReader=new FileReader(file);
        Scanner sc=new Scanner(fileReader);
        String b="";
        String[] arr;
        int count=1;
        System.out.println("-------Transaction details--------\nAccount: "+account);
        while (sc.hasNextLine()){
            b=sc.nextLine();
            arr=b.split(": ");
            if(arr[1].equals(account)){
                System.out.print(count+") ");
                System.out.println(sc.nextLine());
                System.out.println(sc.nextLine());
                System.out.println(sc.nextLine());
                System.out.println(sc.nextLine());
                System.out.println(sc.nextLine());
                count+=1;
            }
        }
        System.out.println("----------------END---------------");
    }
}
