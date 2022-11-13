package CreateAccount.Service.LoggedIn;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginSuccess {
    public void success(String account) throws IOException, SQLException {
        Scanner sc=new Scanner(System.in);
        int c=0;
        while(c!=5) {
            System.out.print("Menu:" +
                    "\n1) Deposit" +
                    "\n2) Withdraw" +
                    "\n3) View Details" +
                    "\n4) Transaction History" +
                    "\n5) Exit" +
                    "\nYour option: ");
            c=sc.nextInt();
            if(c<=5 && c>=1) {
                switch (c) {
                    case 1:
                        Deposit deposit = new Deposit();
                        deposit.deposit(account);
                        break;
                    case 2:
                        Withdraw withdraw = new Withdraw();
                        withdraw.withdraw(account);
                        break;
                    case 3:
                        CheckDetails checkDetails = new CheckDetails();
                        checkDetails.checkDetails(account);
                        break;
                    case 4:
                        ViewTransactions viewTransactions = new ViewTransactions();
                        viewTransactions.viewTransactions(account);
                        break;
                }
            }else{
                System.out.println("Wrong!!! Enter again!!!");
            }
        }
    }
}
