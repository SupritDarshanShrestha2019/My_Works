package SqlitePractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice {
    public static void main(String[] args) throws SQLException {
        Connection conn=ConnectToDB.connectToDB();
        System.out.println("connected");
        PreparedStatement preparedStatement;
//        String query="create table accounts(id integer primary key autoincrement," +
//                "username varchar(30)," +
//                "password varchar(30)," +
//                "name varchar(30)," +
//                "accountNumber varchar(30)," +
//                "address varchar(30),"+
//                "balance varchar(30),"+
//                "email varchar(30),"+
//                "phoneNumber varchar(30))";
//        preparedStatement=conn.prepareStatement(query);
//        preparedStatement.execute();
        preparedStatement=conn.prepareStatement("insert into accounts(username, password, name, accountNumber, address, balance, email, phoneNumber)" +
                " values ('suprit','nnnnnnnnn','suprit','123456789098','basundhara','0','darshan@g.c','9999999999')");
        preparedStatement.executeUpdate();
    }
}
