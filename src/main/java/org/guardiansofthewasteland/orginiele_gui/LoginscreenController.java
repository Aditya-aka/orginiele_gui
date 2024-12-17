package org.guardiansofthewasteland.orginiele_gui;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class LoginscreenController {
    @FXML
    private TextField UsernameBox;

    @FXML
    private TextField PasswordBox;

    @FXML
    private Stage currentstage;

    @FXML
    private Stage previousStage;

    @FXML
    public void setCurrentstage(Stage stage) {
        this.currentstage = stage;
    }

    @FXML
    public void setPreviousstage(Stage stage) {
        this.previousStage = stage;
    }


    @FXML
    private void openNewScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeScreen.fxml"));
            Parent root = loader.load();


            HomescreenController homeController = loader.getController();
            homeController.setCurrentStage(currentstage);


            currentstage.close();


            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
    @FXML
    private void LoginConfirmation () {
        String username = UsernameBox.getText();
        String password = PasswordBox.getText();

        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Login Successful");
            openNewScene();

        } else {
            System.out.println("Login Failed");
        }
    }


}





