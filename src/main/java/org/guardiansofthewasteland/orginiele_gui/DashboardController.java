package org.guardiansofthewasteland.orginiele_gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

public class DashboardController extends Application {

    @FXML
    private AnchorPane anchorPane;

    private static final int REFRESH_INTERVAL = 5000; // 5 seconden interval voor verversing

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/guardiansofthewasteland/orginiele_gui/dashboard.fxml"));

            Parent root = loader.load();
            Scene scene = new Scene(root, 800, 600);

            DashboardController controller = loader.getController();
            controller.startAutoRefresh(); // Start automatische verversing

            primaryStage.setScene(scene);
            primaryStage.setTitle("Dynamic Pane App");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startAutoRefresh() {
        // Instellen van een timer om periodiek data op te halen
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> loadData()); // Haal data op uit de database binnen de JavaFX Application Thread
            }
        }, 0, REFRESH_INTERVAL);
    }

    public void loadData() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);

        try {
            Connection connection = DatabaseConnect.getConnection();
            if (connection != null) {
                System.out.println("Connection established!");

                Statement statement = connection.createStatement();
                String query = "SELECT Container_ID, Locatie, Capaciteit FROM Container";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String location = resultSet.getString("Locatie");
                    int capacity = resultSet.getInt("Capaciteit");
                    System.out.println("Location: " + location + ", Capacity: " + capacity);

                    Pane pane = createPane(location, capacity);
                    vbox.getChildren().add(pane);
                }

                resultSet.close();
                statement.close();
                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            System.out.println("SQL error occurred:");
            e.printStackTrace();
        }

        vbox.setPrefWidth(AnchorPane.USE_COMPUTED_SIZE); // Ensure VBox fills width of AnchorPane
        anchorPane.setMinHeight(600); // Set minimum height for AnchorPane to extend background
        anchorPane.getChildren().clear();
        anchorPane.getChildren().add(vbox);
    }

    private Pane createPane(String location, int capacity) {
        Pane pane = new Pane();
        pane.setPrefSize(222, 79);
        pane.setStyle("-fx-background-color: #cbd2a4; -fx-background-radius: 10%;");

        Label label = new Label(location);
        label.setLayoutX(14);
        label.setLayoutY(4);
        label.setTextFill(javafx.scene.paint.Color.web("#738c6d"));
        label.setFont(new javafx.scene.text.Font("Berlin Sans FB", 18));

        double progress = Math.min(capacity / 200.0, 1.0);
        ProgressBar progressBar = new ProgressBar(progress);
        progressBar.setLayoutX(11);
        progressBar.setLayoutY(31);
        progressBar.setPrefSize(200, 29);
        progressBar.setStyle("-fx-background-color: #000000;");

        if (capacity < 50) {
            progressBar.setStyle("-fx-accent: green;");
        } else if (capacity >= 50 && capacity < 100) {
            progressBar.setStyle("-fx-accent: yellow;");
        } else if (capacity >= 100 && capacity < 150) {
            progressBar.setStyle("-fx-accent: orange;");
        } else {
            progressBar.setStyle("-fx-accent: red;");
        }

        pane.getChildren().addAll(label, progressBar);

        return pane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
