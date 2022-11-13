package AMS_Application_using_JavaFx.Login;

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
import java.util.Scanner;

public class LoginController {
    @FXML
    public TextField usernameTxt;
    @FXML
    public TextField passwordTxt;
    @FXML
    public Label status;
    public String account;
    public void submitForm(ActionEvent event) throws IOException {
        File file =new File("D:\\Work\\BankingManagementSystem_AMS\\src\\AccountHolder.txt");
        File file2 =new File("D:\\Work\\BankingManagementSystem_AMS\\src\\Current.txt");
        if(!file2.exists()){
            file2.createNewFile();
        }
        FileReader fileReader=new FileReader(file);
        Scanner sc2=new Scanner(fileReader);
        String username=usernameTxt.getText();
        String password=passwordTxt.getText();
        String b="";
        String accountDetails;
        String[] arr;
        int count=0;
        while(sc2.hasNextLine()) {
            accountDetails="";
            b= sc2.nextLine();//username
            arr=b.split(": ");//split username: and value
            if(arr[0].equals("Username")) {
                if (arr[1].equals(username)) {
                    b = sc2.nextLine();//password
                    arr = b.split(": ");
                    if (arr[1].equals(password)) {
                        b = sc2.nextLine();//name
                        accountDetails+=b+"\n";//storing in different string so that it can be shown in later context
                        b = sc2.nextLine();//account number
                        arr = b.split(": ");//to split AccountNumber,account number
                        accountDetails+=b+"\n";
                        b = sc2.nextLine();//address
                        accountDetails+=b+"\n";
                        b = sc2.nextLine();//balance
                        accountDetails+=b+"\n";
                        b = sc2.nextLine();//email
                        accountDetails+=b+"\n";
                        b = sc2.nextLine();//phone number
                        accountDetails+=b+"\n";
                        String account = arr[1];//storing account to another string as it is unique
                        this.account=account;
                        FileWriter fileWriter=new FileWriter(file2);
                        fileWriter.write(account);
                        fileWriter.close();
                        status.setText("Successful");
                        count=1;
                        Parent root = FXMLLoader.load(getClass().getResource("Loggedin/Loggedin.fxml"));
                        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                        Scene scene=new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                }
            }
        }
        if(count==0){
            status.setText("Failed");
        }
    }
    public void returnBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx/Main.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
