package CreateAccount.Service.LoggedIn;

import Sqlite.ConnectToDB;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Withdraw {
    void withdraw(String account) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        //Read deposit
        System.out.print("Enter the withdraw amount: ");
        long amount = sc.nextLong();

        Connection con = ConnectToDB.connectToDB();
        Statement statement = con.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select balance from accounts where accountNumber=" + account);
        String oldBalance = resultSet1.getString(1);

        long newBalance = Long.parseLong(oldBalance) - amount;
        if(newBalance>=0) {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update accounts set balance='" + Long.toString(newBalance) + "' where accountNumber=" + account);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            TransactionToDb transactionToDb = new TransactionToDb();
            transactionToDb.transaction(account, Long.toString(newBalance), oldBalance, Long.toString(amount), "Credit");
        }else{
            System.out.println("Insufficient balance");
        }
    }
}
