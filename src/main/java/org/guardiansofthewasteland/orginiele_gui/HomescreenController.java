package org.guardiansofthewasteland.orginiele_gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HomescreenController {

    private Stage currentStage;
    private Stage previousStage;


    public void setCurrentStage(Stage stage) {
        this.currentStage = stage;
    }

        //public void setPreviousStage(Stage stage) {
      //  this.previousStage = stage;
    //}

    @FXML
    private void goBackToPreviousScreen() {
        try {

            if (currentStage != null) {
                System.out.println("Closing current stage (HomeScreen)...");
                currentStage.close();
            }  else {
            System.out.println("currentStage is null, can't close it.");
        }


            FXMLLoader loader = new FXMLLoader(getClass().getResource("Loginscreen.fxml"));
            Parent root = loader.load();


            Scene scene = new Scene(root);
            Stage loginStage = new Stage();
            loginStage.setScene(scene);
            loginStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void OpenDashboard() {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = fxmlLoader.load();

            // Get the controller and call the loadData method
            DashboardController controller = fxmlLoader.getController();
            controller.loadData();

            Stage stage = new Stage();
            stage.setTitle("Dashboard");
            stage.setScene(new Scene(root, 259, 409));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void OpenRoute() {


        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RouteScreen.fxml"));
            Parent root = fxmlLoader.load();


            Stage stage = new Stage();
            stage.setTitle("Route");
            stage.setScene(new Scene(root, 259, 409));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void OpenAdmin() {


        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin.fxml"));
            Parent root = fxmlLoader.load();


            Stage stage = new Stage();
            stage.setTitle("Route");
            stage.setScene(new Scene(root, 259, 409));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void OpenUser () {


        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("user.fxml"));
            Parent root = fxmlLoader.load();


            Stage stage = new Stage();
            stage.setTitle("Route");
            stage.setScene(new Scene(root, 259, 409));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
