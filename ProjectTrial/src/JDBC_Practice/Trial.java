package JDBC_Practice;

import java.sql.*;

public class Trial {
    public static void main(String[] args) {
        Connection conn=ConnectToDB.connectToDB();
        System.out.println("Connected");
        try{
            //Inserting into the table
            System.out.println("Inserting Bivek into table ");
            PreparedStatement st = conn.prepareStatement("INSERT INTO professor(name,subject,salary) values('Bivek','Database',150000)");
            st.executeUpdate();
            st = conn.prepareStatement("SELECT * from professor");
            ResultSet rs=st.executeQuery();
            System.out.println("id\t\t"+"name\t\t"+"age\t\t"+"subject\t\t"+"salary");
            while (rs.next())
            {
                System.out.print(rs.getInt(("id"))+"\t\t");
                System.out.print(rs.getString(("name"))+"\t\t");
//                System.out.print(rs.getString(("age"))+"\t\t");
                System.out.print("\t\t"+rs.getString(("subject"))+"\t\t");
                System.out.print(rs.getInt(("salary")));
                System.out.println();
            }
            //Removing from the table
            System.out.println();
            System.out.println("Deleting professor Bivek from table");
            st = conn.prepareStatement("DELETE from professor where name='Bivek'");
            st.executeUpdate();
            st = conn.prepareStatement("SELECT * from professor");
            ResultSet rs2=st.executeQuery();
            System.out.println("id\t\t"+"name\t\t"+"age\t\t"+"subject\t\t"+"salary");
            while (rs2.next())
            {
                System.out.print(rs2.getInt(("id"))+"\t\t");
                System.out.print(rs2.getString(("name"))+"\t\t");
//                System.out.print(rs2.getString(("age"))+"\t\t");
                System.out.print("\t\t"+rs2.getString(("subject"))+"\t\t");
                System.out.print(rs2.getInt(("salary")));
                System.out.println();
            }
            st.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}