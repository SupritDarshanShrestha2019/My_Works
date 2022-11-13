package CreateAccount.Service.LoggedIn;

import Sqlite.ConnectToDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ViewTransactions {
    public void viewTransactions(String account) throws FileNotFoundException, SQLException {
        Connection con= ConnectToDB.connectToDB();
        Statement statement=con.createStatement();
        String detail="";
        detail+="Account number: "+account+"\n";

        ResultSet resultSet2=statement.executeQuery("select transactionDate,accountNumber,type,oldBalance,newBalance,amount from transactions where accountNumber="+account);
        int count=1;
        while(resultSet2.next()){
                detail += count + ") ";
                detail += "Date= "+resultSet2.getString(1)+"\n";
                detail += "Account number= "+resultSet2.getString(2)+"\n";
                detail += "Type= "+resultSet2.getString(3)+"\n";
                detail += "Old Balance= "+resultSet2.getString(4)+"\n";
                detail += "Amount= "+resultSet2.getString(6)+"\n";
                detail += "New Balance= "+resultSet2.getString(5)+"\n\n";
                count+=1;

        }
        System.out.println(detail);
        con.close();
    }
}
