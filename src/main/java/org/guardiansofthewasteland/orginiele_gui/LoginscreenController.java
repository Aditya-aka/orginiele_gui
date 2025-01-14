package org.guardiansofthewasteland.orginiele_gui;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import org.mindrot.jbcrypt.BCrypt;




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
    private void CheckLogin() {
        String username = UsernameBox.getText();
        String password = PasswordBox.getText();

        if (LoginConfirmation(username, password)) {
            openNewScene();
        } else {
            System.out.println("Login failed. Please check your username and password.");
        }
    }

    @FXML
    private boolean LoginConfirmation(String username, String password) {
        Connection connection = null;
        Statement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnect.getConnection();

            if (connection != null) {
                System.out.println("Connection established!");


                String query = "SELECT password FROM medewerker WHERE username = '" + username + "'";
                preparedStatement = connection.prepareStatement(query);


                resultSet = preparedStatement.executeQuery(query);

                if (resultSet.next()) {
                    String storedHashedPassword = resultSet.getString("password");


                    if (BCrypt.checkpw(password, storedHashedPassword)) {
                        return true;
                    }
                }
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("SQL error occurred");
            e.printStackTrace();
        } finally {

            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}




