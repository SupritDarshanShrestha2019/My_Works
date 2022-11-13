package CreateAccount.Service.LoggedIn;

import Sqlite.ConnectToDB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class TransactionToDb {
    public void transaction(String account,String newBalance,String oldBalance,String amount,String type) throws IOException, SQLException {
        Connection con= ConnectToDB.connectToDB();
        LocalDate localDate=LocalDate.now();
        PreparedStatement st = con.prepareStatement("insert into transactions(transactionDate, accountNumber, type, oldBalance, newBalance, amount) values (?,?,?,?,?,?)");
        st.setString(1,localDate.toString());
        st.setString(2,account);
        st.setString(3,type);
        st.setString(4,oldBalance);
        st.setString(5,newBalance);
        st.setString(6,amount);
        st.executeUpdate();
    }
}
