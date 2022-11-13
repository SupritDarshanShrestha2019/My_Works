package AMS_Application_using_JavaFx_Using_Sqlite.Login.ShowTransactions;

import SqlitePractice.ConnectToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ShowTransactionController {
    @FXML
    Label details;
    public void show(ActionEvent event) throws IOException, SQLException {
        File file1 = new File("id.txt");
        FileReader fileReader1=new FileReader(file1);

        Scanner sc1=new Scanner(fileReader1);
        int id=sc1.nextInt();

        Connection con= ConnectToDB.connectToDB();
        Statement statement=con.createStatement();
        ResultSet resultSet1=statement.executeQuery("select accountNumber from accounts where id="+id);
        String account=resultSet1.getString(1);
        String detail="";
        detail+="Account number: "+account+"\n\n";

        ResultSet resultSet2=statement.executeQuery("select transactionDate,accountNumber,type,oldBalance,newBalance,amount from transactions");
        int count=1;
        while(resultSet2.next()){
            if(resultSet2.getString(2).equals(account)) {
                detail += count + ") ";
                detail += "Date= "+resultSet2.getString(1)+"\n";
                detail += "Account number= "+resultSet2.getString(2)+"\n";
                detail += "Type= "+resultSet2.getString(3)+"\n";
                detail += "Old Balance= "+resultSet2.getString(4)+"\n";
                detail += "Amount= "+resultSet2.getString(6)+"\n";
                detail += "New Balance= "+resultSet2.getString(5)+"\n\n";
                count+=1;
            }
        }

        details.setText(detail);
        con.close();
        fileReader1.close();
        sc1.close();
    }
    public void returnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx_Using_Sqlite/Login/Loggedin/Loggedin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
