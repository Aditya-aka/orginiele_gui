package org.guardiansofthewasteland.orginiele_gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView imageview;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField locationField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField passwordField;

    @FXML
    private void onAddUserButtonClick() {
        String name = nameField.getText();
        String email = emailField.getText();
        String address = locationField.getText();
        String phone = phoneField.getText();
        String password = passwordField.getText();

        System.out.println(name);
        System.out.println(email);
        System.out.println(address);
        System.out.println(phone);
        System.out.println(password);

        welcomeText.setText("De account is aangemaakt.");
        System.out.println("De account is aangemaakt.");
    }
    @FXML
    private void onReturnButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 600);

        Stage stage = (Stage) welcomeText.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

        System.out.println("onReturnButtonClick() called");
    }

}