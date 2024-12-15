package org.guardiansofthewasteland.orginiele_gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

import java.util.List;

public class DashboardController {

    @FXML
    private Pane pane1;
    @FXML
    private Label label1;
    @FXML
    private ProgressBar progressBar1;

    @FXML
    private Pane pane2;
    @FXML
    private Label label2;
    @FXML
    private ProgressBar progressBar2;

    @FXML
    private Pane pane3;
    @FXML
    private Label label3;
    @FXML
    private ProgressBar progressBar3;

    @FXML
    private Pane pane4;
    @FXML
    private Label label4;
    @FXML
    private ProgressBar progressBar4;

    @FXML
    public void initialize() {
        List<RegionProgress> regionProgressList = DatabaseConnect.getRegionProgress();
        if (regionProgressList.size() >= 4) {
            RegionProgress region1 = regionProgressList.get(0);
            label1.setText(region1.getRegionName());
            progressBar1.setProgress(region1.getProgress());

            RegionProgress region2 = regionProgressList.get(1);
            label2.setText(region2.getRegionName());
            progressBar2.setProgress(region2.getProgress());

            RegionProgress region3 = regionProgressList.get(2);
            label3.setText(region3.getRegionName());
            progressBar3.setProgress(region3.getProgress());

            RegionProgress region4 = regionProgressList.get(3);
            label4.setText(region4.getRegionName());
            progressBar4.setProgress(region4.getProgress());
        }
    }
}
