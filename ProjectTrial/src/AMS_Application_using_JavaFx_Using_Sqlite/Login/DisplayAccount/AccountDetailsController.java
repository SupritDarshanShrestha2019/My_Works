package AMS_Application_using_JavaFx_Using_Sqlite.Login.DisplayAccount;

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

public class AccountDetailsController {
    @FXML
    Label details;
    public void show(ActionEvent event) throws IOException, SQLException {
        File file1 = new File("id.txt");
        FileReader fileReader1=new FileReader(file1);
        Scanner sc1=new Scanner(fileReader1);
        int id=sc1.nextInt();
        String detail="";
        Connection con= ConnectToDB.connectToDB();
        Statement statement=con.createStatement();
        ResultSet resultSet1=statement.executeQuery("select name,accountNumber,address,balance,email,phoneNumber from accounts where id="+id);
        detail+="Name= "+resultSet1.getString(1)+"\n";
        detail+="Account number= "+resultSet1.getString(2)+"\n";
        detail+="Address= "+resultSet1.getString(3)+"\n";
        detail+="Balance= "+resultSet1.getString(4)+"\n";
        detail+="Email= "+resultSet1.getString(5)+"\n";
        detail+="Phone number= "+resultSet1.getString(6);
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