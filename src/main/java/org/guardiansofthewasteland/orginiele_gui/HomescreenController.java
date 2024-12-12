package org.guardiansofthewasteland.orginiele_gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HomescreenController {

    @FXML
    private void OpenDashboard() {


        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = fxmlLoader.load();


            Stage stage = new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(new Scene(root, 259, 409));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
