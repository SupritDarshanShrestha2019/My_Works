package AMS_Application_using_JavaFx.Login.ShowTransactions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ShowTransactionController {
    @FXML
    Label details;
    public void show(ActionEvent event) throws IOException {
        File file3 = new File("D:\\Work\\BankingManagementSystem_AMS\\src\\Current.txt");
        BufferedReader fileReader3=new BufferedReader(new FileReader(file3));
        Scanner sc3 = new Scanner(fileReader3);
        String account=sc3.next();
        sc3.close();
        File file=new File("D:\\Work\\BankingManagementSystem_AMS\\src\\Transactions.txt");
        FileReader fileReader=new FileReader(file);
        Scanner sc=new Scanner(fileReader);
        String b="";
        String c="";
        String[] arr;
        int count=1;
        c+="Account: "+account+"\n";
        while (sc.hasNextLine()){
            b=sc.nextLine();
            arr=b.split(": ");
            if(arr[1].equals(account)){
                c+=count+") ";
                c+=sc.nextLine()+"\n";
                c+=sc.nextLine()+"\n";
                c+=sc.nextLine()+"\n";
                c+=sc.nextLine()+"\n";
                c+=sc.nextLine()+"\n";
                count+=1;
            }
        }
        details.setText(c);
    }
    public void returnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx/Login/Loggedin/Loggedin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
