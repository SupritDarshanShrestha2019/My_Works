import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc=new Scanner(System.in);
        int c=0;
        while(c!=3) {
                System.out.print("Menu:\n" +
                        "1) Create new account\n" +
                        "2) Login\n" +
                        "3) Exit\n" +
                        "Your option: ");
                c = sc.nextInt();
            if(c>=1 && c<=3) {
                switch (c) {
                    case 1:
                        CreateAccountMain.create();
                        break;
                    case 2:
                        LoginAccount.login();
                        break;
                }
            }else{
                System.out.println("Wrong!!! Enter again!!!");
            }
        }
    }
}
