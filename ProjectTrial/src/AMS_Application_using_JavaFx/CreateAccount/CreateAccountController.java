package AMS_Application_using_JavaFx.CreateAccount;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Random;
import AMS_Application_using_JavaFx.CreateAccount.pozo.*;
import javafx.stage.Stage;

public class CreateAccountController {
    @FXML
    public TextField usernameTxt;
    @FXML
    public TextField passwordTxt;
    @FXML
    public TextField nameTxt;
    @FXML
    public Label accountNumberTxt;
    @FXML
    public TextField addressTxt;
    @FXML
    public Label balanceTxt;
    @FXML
    public TextField emailTxt;
    @FXML
    public TextField phoneNumberTxt;
    @FXML
    public Label status;
    public void submitForm(ActionEvent event) throws IOException,NullPointerException {
        String s;
        String usernameVal=usernameTxt.getText();
        Username username=new Username(usernameVal);
        s=username.s;
        if(s.equals("yes")){
            String passwordVal=passwordTxt.getText();
            Password password=new Password(passwordVal);
            s=password.s;
            if(s.equals("yes")){
                String accountHolderNameVal=nameTxt.getText();
                AccountHolderName accountHolderName=new AccountHolderName(accountHolderNameVal);
                s=accountHolderName.s;
                if(s.equals("yes")){
                    Random random = new Random();
                    String accountNumberVal=Long.toString(Math.round(random.nextFloat() * Math.pow(10,12)));
                    AccountNumber accountNumbers=new AccountNumber(accountNumberVal);
                    String addressVal=addressTxt.getText();
                    Address address=new Address(addressVal);
                    s=address.s;
                    if(s.equals("yes")){
                        long balanceVal=0;
                        Balance balances=new Balance(balanceVal);
                        String emailVal=emailTxt.getText();
                        Email email=new Email(emailVal);
                        s=email.s;
                        if(s.equals("yes")){
                            String phoneNumberVal=phoneNumberTxt.getText();
                            PhoneNumber phoneNumber=new PhoneNumber(phoneNumberVal);
                            s=phoneNumber.s;
                            if(s.equals("yes")){
                                username.storeUsername(usernameVal);
                                password.storePassword(passwordVal);
                                accountHolderName.storeName(accountHolderNameVal);
                                accountNumbers.storeAccNumber(accountNumberVal);
                                address.storeAddress(addressVal);
                                balances.storeBalance(Long.toString(balanceVal));
                                email.storeEmail(emailVal);
                                phoneNumber.storeNumber(phoneNumberVal);
                                status.setText("Error in username.");
                                Parent root = FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx/Main.fxml"));
                                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                                Scene scene=new Scene(root);
                                stage.setScene(scene);
                                stage.show();
                            }else {
                                status.setText("Error in phone number.");
                            }
                        }else{
                            status.setText("Error in email.");
                        }
                    }else{
                        status.setText("Error in Address.");
                    }
                }else{
                    status.setText("Error in Name.");
                }
            }else{
                status.setText("Error in password.");
            }
        }else{
            status.setText("Error in username.");
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
