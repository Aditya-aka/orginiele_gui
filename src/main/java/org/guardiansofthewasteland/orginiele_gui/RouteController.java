package org.guardiansofthewasteland.orginiele_gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class RouteController {
    @FXML
    private Label percentageTwo;

    @FXML
    private Label percentageOne;
    @FXML
    private Label percentageThree;
    @FXML
    private Label percentageFour;
    @FXML
    private Label percentageFive;
    @FXML
    private Label percentageSix;

    @FXML
    public void handleButtonOne() {
        percentageOne.setText("80%");
    }
    @FXML
    public void handleButtonOneRemove() {
        percentageOne.setText("");
    }

    @FXML
    public void handleButtonTwo() {
        percentageTwo.setText("31%");
    }
    @FXML
    public void handleButtonTwoRemove() {
        percentageTwo.setText("");
    }
    @FXML
    public void handleButtonThree() {
        percentageThree.setText("47%");
    }
        @FXML
        public void handleButtonThreeemove() {
            percentageThree.setText("");
        }
    @FXML
    public void handleButtonFour() {
        percentageFour.setText("52%");
    }
            @FXML
            public void handleButtonFourRemove() {
                percentageFour.setText("");
            }
    @FXML
    public void handleButtonFive() {
        percentageFive.setText("60%");
    }
    @FXML
    public void handleButtonFiveRemove() {
        percentageFive.setText("");
    }
    @FXML
    public void handleButtonSix () {
        percentageSix.setText("10%");
    }
    @FXML
    public void handleButtonSixRemove () {
        percentageSix.setText("");
    }

    @FXML
    public void TerugKnopje() {
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
    }


