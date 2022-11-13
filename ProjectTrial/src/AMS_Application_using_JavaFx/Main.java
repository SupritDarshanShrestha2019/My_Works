package AMS_Application_using_JavaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("/AMS_Application_using_JavaFx/Main.fxml"));
        Scene scene=new Scene(root);
        primaryStage.setTitle("Account Management System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
