package AMS_Application_using_JavaFx_Using_Sqlite.Login.Withdraw;

import AMS_Application_using_JavaFx_Using_Sqlite.Login.TransactionToDb;
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
import java.sql.*;
import java.util.Scanner;

public class WithdrawController {
    @FXML
    TextField amountTxt;
    @FXML
    Label status;
    public void submitForm(ActionEvent event) throws IOException, SQLException {
        File file1=new File("D:\\Work\\ProjectTrial\\id.txt");
        FileReader fileReader1=new FileReader(file1);

        Scanner sc1=new Scanner(fileReader1);
        int id=sc1.nextInt();

        Connection con= ConnectToDB.connectToDB();
        Statement statement=con.createStatement();
        ResultSet resultSet1 = statement.executeQuery("select balance,accountNumber from accounts where id=" + id);
        String oldBalance = resultSet1.getString(1);
        String account = resultSet1.getString(2);

        String amount=amountTxt.getText();
        long newBalance=Long.parseLong(oldBalance)-Long.parseLong(amount);
        if(newBalance<0) {
            PreparedStatement preparedStatement;
            preparedStatement=con.prepareStatement("update accounts set balance='"+oldBalance+"' where id="+id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            status.setText("The value became negative\nIf you dont want to withdraw press 0");
        }else {
            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement("update accounts set balance='" + Long.toString(newBalance) + "' where id=" + id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();

            TransactionToDb transactionToDb = new TransactionToDb();
            transactionToDb.transaction(account, Long.toString(newBalance), oldBalance, amount, "Debit");
            Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx_Using_Sqlite/Login/Loggedin/Loggedin.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void returnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx_Using_Sqlite/Login/Loggedin/Loggedin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}