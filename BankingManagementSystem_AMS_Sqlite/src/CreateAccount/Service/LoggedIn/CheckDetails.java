package CreateAccount.Service.LoggedIn;

import Sqlite.ConnectToDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CheckDetails {
    public void checkDetails(String account) throws FileNotFoundException, SQLException {
        String detail="";
        Connection con= ConnectToDB.connectToDB();
        Statement statement=con.createStatement();
        ResultSet resultSet1=statement.executeQuery("select name,accountNumber,address,balance,email,phoneNumber from accounts where accountNumber="+account);
        detail+="Name= "+resultSet1.getString(1)+"\n";
        detail+="Account number= "+resultSet1.getString(2)+"\n";
        detail+="Address= "+resultSet1.getString(3)+"\n";
        detail+="Balance= "+resultSet1.getString(4)+"\n";
        detail+="Email= "+resultSet1.getString(5)+"\n";
        detail+="Phone number= "+resultSet1.getString(6);
        System.out.println(detail);
        con.close();
    }
}
