package AMS_Application_using_JavaFx_Using_Sqlite.Login;

import SqlitePractice.ConnectToDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginController {
    @FXML
    public TextField usernameTxt;
    @FXML
    public TextField passwordTxt;
    @FXML
    public Label status;
    public String account;
    public void submitForm(ActionEvent event) throws IOException, SQLException {
        File file=new File("id.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter=new FileWriter(file);
        Connection con= ConnectToDB.connectToDB();
        Statement statement=con.createStatement();
        ResultSet resultSet=statement.executeQuery("select id from accounts where username='"+usernameTxt.getText()+"' and password='"+passwordTxt.getText()+"'");
        if(resultSet.next()){
            fileWriter.write(resultSet.getString(1));
            fileWriter.close();
            statement.close();
            con.close();
            Parent root = FXMLLoader.load(getClass().getResource("Loggedin/Loggedin.fxml"));
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            status.setText("Error in username or password.");
        }
    }
    public void returnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx_Using_Sqlite/Main.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
