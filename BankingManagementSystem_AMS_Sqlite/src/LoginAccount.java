import CreateAccount.Service.LoggedIn.LoginSuccess;
import Sqlite.ConnectToDB;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginAccount {
    static void login() throws IOException, SQLException {
        Scanner sc=new Scanner(System.in);
        Connection con= ConnectToDB.connectToDB();
        Statement statement=con.createStatement();
        System.out.print("Username: ");
        String username=sc.next();
        System.out.print("Password: ");
        String password=sc.next();
        ResultSet resultSet=statement.executeQuery("select accountNumber from accounts where username='"+username+"' and password='"+password+"'");
        if(resultSet.next()){
            String account=resultSet.getString(1);
            statement.close();
            con.close();
            LoginSuccess loginSuccess = new LoginSuccess();
            loginSuccess.success(account);
        }
    }
}
