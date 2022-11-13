package AMS_Application_using_JavaFx.Login.Deposit;

import AMS_Application_using_JavaFx.Login.TransactionToFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DepositController {
    @FXML
    TextField amountTxt;
    public void submitForm(ActionEvent event) throws IOException {
        File file = new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        File file3 = new File("D:\\Work\\BankingManagementSystem_AMS\\src\\Current.txt");
        //Read deposit
        long deposit = Long.parseLong(amountTxt.getText());
        //File reading
        BufferedReader fileReader=new BufferedReader(new FileReader(file));
        Scanner sc2 = new Scanner(fileReader);
        BufferedReader fileReader3=new BufferedReader(new FileReader(file3));
        Scanner sc3 = new Scanner(fileReader3);
        String account=sc3.next();
        sc3.close();
        long newBalance = 0, oldBalance = 0;
        String temp = "";
        String newS = "";
        while (sc2.hasNext()) {
            temp = sc2.next();
            newS += temp;
            if (!Pattern.matches("[a-zA-Z]+:", temp)) {
                newS += "\n";
            } else if (Pattern.matches("((\\+977)[0-9]{10})||((977)[0-9]{10})||[0-9]{10}", temp)) {
            } else {
                newS += " ";
            }
            if (temp.equals(account)) {
                newS += sc2.next() + " " + sc2.next() + "\n" + sc2.next();
                oldBalance = Long.parseLong(sc2.next());
                newBalance = oldBalance + deposit;
                temp = Long.toString(newBalance);
                newS += " " + temp;
                newS += "\n";
            }
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        fileWriter.write(newS);
        fileWriter.close();
        sc2.close();
        System.out.println("Deposit successful!");
        TransactionToFile transactionToFile = new TransactionToFile();
        transactionToFile.transaction(account, newBalance, oldBalance, deposit, "Credit");
        sc3.close();
        Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx/Login/Loggedin/Loggedin.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void returnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx/Login/Loggedin/Loggedin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}