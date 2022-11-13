package AMS_Application_using_JavaFx.Login.DisplayAccount;

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
import java.util.regex.Pattern;

public class AccountDetailsController {
    @FXML
    Label details;
    public void show(ActionEvent event) throws IOException {
        File file3 = new File("D:\\Work\\BankingManagementSystem_AMS\\src\\Current.txt");
        BufferedReader fileReader3=new BufferedReader(new FileReader(file3));
        Scanner sc3 = new Scanner(fileReader3);
        String account=sc3.next();
        sc3.close();
        File file = new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        BufferedReader fileReader=new BufferedReader(new FileReader(file));
        BufferedReader fileReader2=new BufferedReader(new FileReader(file));
        Scanner sc1 = new Scanner(fileReader);
        Scanner sc2 = new Scanner(fileReader2);
        String newS = "";
        String temp="";
        String[] arr;
        temp= sc1.nextLine();
        temp= sc1.nextLine();
        temp= sc1.nextLine();
        while (sc1.hasNextLine()) {
            temp=sc1.nextLine();
            arr=temp.split(": ");
            if (arr[1].equals(account)) {
                sc2.nextLine();
                sc2.nextLine();
                newS+= sc2.nextLine()+"\n";
                newS+= sc2.nextLine()+"\n";
                newS+= sc2.nextLine()+"\n";
                newS+= sc2.nextLine()+"\n";
                newS+= sc2.nextLine()+"\n";
                newS+= sc2.nextLine();
            }else{
                if(sc2.hasNextLine()) {
                    sc2.nextLine();
                    sc2.nextLine();
                    sc2.nextLine();
                    sc2.nextLine();
                    sc2.nextLine();
                    sc2.nextLine();
                    sc2.nextLine();
                    sc2.nextLine();
                }
                sc1.nextLine();
                sc1.nextLine();
                sc1.nextLine();
                if(sc1.hasNextLine()) {
                    sc1.nextLine();
                    sc1.nextLine();
                    sc1.nextLine();
                    sc1.nextLine();
                }
            }
        }
        details.setText(newS);
    }
    public void returnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx/Login/Loggedin/Loggedin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
