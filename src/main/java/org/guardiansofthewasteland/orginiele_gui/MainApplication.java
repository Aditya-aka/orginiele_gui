package org.guardiansofthewasteland.orginiele_gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        switchView(stage, "Loginscreen.fxml");
    }

    public static void switchView(Stage stage, String fileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fileName));
        Scene scene = new Scene(fxmlLoader.load(), 320, 600);
        stage.setTitle("Guardians of the Wasteland");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}