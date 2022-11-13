import CreateAccount.pozo.*;
import Sqlite.ConnectToDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class CreateAccountMain {
    static void create() throws IOException, SQLException {
        Scanner sc=new Scanner(System.in);
        //Username
        System.out.print("Username: ");
        String usernameVal=sc.nextLine();
        Username username=new Username(usernameVal);
        //Password
        System.out.print("Password: ");
        String passwordVal=sc.nextLine();
        Password password=new Password(passwordVal);
        //Name
        System.out.print("Name: ");
        String accountHolderNameVal=sc.nextLine();
        AccountHolderName accountHolderName=new AccountHolderName(accountHolderNameVal);
        //Account number
        System.out.print("AccountNumber: ");
        Random random = new Random();
        String accountNumberVal=Long.toString(Math.round(random.nextFloat() * Math.pow(10,12)));
        AccountNumber accountNumber=new AccountNumber(accountNumberVal);
        System.out.println(accountNumberVal);
        //Address
        System.out.print("Address: ");
        String addressVal=sc.nextLine();
        Address address=new Address(addressVal);
        //Balance
        long balanceVal=0;
        Balance balance=new Balance(balanceVal);
        //Email
        System.out.print("Email: ");
        String emailVal=sc.next();
        Email email=new Email(emailVal);
        //Phone Number
        System.out.print("PhoneNumber: ");
        String phoneNumberVal=sc.next();
        PhoneNumber phoneNumber=new PhoneNumber(phoneNumberVal);
        //Storing
        Connection conn= ConnectToDB.connectToDB();
        PreparedStatement st = conn.prepareStatement("insert into " +
                "accounts(username, password, name, accountNumber, address, balance, email, phoneNumber) " +
                "values (?,?,?,?,?,?,?,?)");
        st.setString(1,usernameVal);
        st.setString(2,passwordVal);
        st.setString(3,accountHolderNameVal);
        st.setString(4,accountNumberVal);
        st.setString(5,addressVal);
        st.setString(6,Long.toString(balanceVal));
        st.setString(7,emailVal);
        st.setString(8,phoneNumberVal);
        st.executeUpdate();
        st.close();
        conn.close();
    }
}
