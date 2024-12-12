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
    private void onAddUserButtonClick() throws IOException {
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
  /*  @FXML
    private void onReturnButtonClick() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomescreenController.fxml"));
        MainApplication.switchView((Stage) welcomeText.getScene().getWindow(), "HomescreenController.fxml");

        System.out.println("onReturnButtonClick() called");
    } */

}
