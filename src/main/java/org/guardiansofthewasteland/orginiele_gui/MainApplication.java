package org.guardiansofthewasteland.orginiele_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage primarystage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Loginscreen.fxml"));
        Parent root = loader.load();

        primarystage.setTitle("GuardiansOfThewasteland");
        primarystage.setScene(new Scene(root));
        primarystage.show();

        LoginscreenController controller = loader.getController();
        controller.setCurrentstage(primarystage);
    }



    public static void main(String[] args) {
        launch();
    }
}