package org.guardiansofthewasteland.orginiele_gui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginscreenController {

    @FXML
    private TextField UsernameBox;

    @FXML
    private TextField PasswordBox;




    @FXML
    private void NewScene() {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Homescreen.fxml"));
            Parent root = fxmlLoader.load();


            Stage stage = new Stage();
            stage.setTitle("HomeScreen");
            stage.setScene(new Scene(root, 259, 409));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void LoginConfirmation() {
        String username = UsernameBox.getText();
        String password = PasswordBox.getText();

        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Login Successful");
            NewScene();

        } else {
            System.out.println("Login Failed");
        }
    }
}