package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;

public class ReceptionFormController {
    public AnchorPane receptionFormContext;
    public AnchorPane repSlideBarContext;
    public AnchorPane loadUnit;
    public JFXButton btnrepAdmission;
    public JFXButton btnrepPCU;
    public JFXButton btnrepOPD;

    public void OpenOPDCounterForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/OPDCounterForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadUnit.getChildren().clear();
        loadUnit.getChildren().add(load);
    }

    public void OpenPCUCounterForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PCUCounterForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadUnit.getChildren().clear();
        loadUnit.getChildren().add(load);
    }

    public void OpenAdmissionRoomForm(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AdmissionRoomCounterForm.fxml");
        Parent load = FXMLLoader.load(resource);
        loadUnit.getChildren().clear();
        loadUnit.getChildren().add(load);
    }
}
