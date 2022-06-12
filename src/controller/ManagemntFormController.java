package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagemntFormController {
    public AnchorPane topPAne;
    public JFXButton btnPatientHistory1;
    public JFXButton btnPatientHistory11;
    public JFXButton btnPatientHistory111;
    public AnchorPane MangemntSidePan;
    public JFXButton btnPatientHistory;
    public JFXButton btnClinicRates;
    public JFXButton btnDoctorDetails;
    public AnchorPane loadInterfaces;

    public void OpenPatientHistory(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/PatientHistory.fxml");
        Parent load = FXMLLoader.load(resource);
        loadInterfaces.getChildren().clear();
        loadInterfaces.getChildren().add(load);
    }

    public void OpenClinicRates(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ClinicsRates.fxml");
        Parent load = FXMLLoader.load(resource);
        loadInterfaces.getChildren().clear();
        loadInterfaces.getChildren().add(load);
    }

    public void OpenDoctorDetails(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DoctorDetails.fxml");
        Parent load = FXMLLoader.load(resource);
        loadInterfaces.getChildren().clear();
        loadInterfaces.getChildren().add(load);
    }


    public void AddReceptionist(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/AddReceptionist.fxml"));
        Scene scene = new Scene(load);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void UpdateReceptionist(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/UpdateReceptions.fxml"));
        Scene scene = new Scene(load);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void DeleteReceptionist(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/DeleteReceptions.fxml"));
        Scene scene = new Scene(load);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void AddDoctors(ActionEvent actionEvent) {
        Parent load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("../view/AddDoctors.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void UpdateDoctors(ActionEvent actionEvent) {
        Parent load = null;
        try {
            load = FXMLLoader.load(getClass().getResource("../view/UpdateDoctors.fxml"));
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void DeleteDoctors(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/DeleteDoctors.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
