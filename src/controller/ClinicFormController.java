package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class ClinicFormController {
    public AnchorPane eyeclinicPane;
    public JFXButton btnEyeClinic;
    public AnchorPane ENTclinicPane;
    public JFXButton btnENTClinic;
    public AnchorPane SurgicalclinicPane;
    public JFXButton btnSurgicalClinic;
    public HBox ScrollBarClinics;
    public AnchorPane MedicalclinicPane;
    public JFXButton btnMedicalClinic;
    public AnchorPane STDclinicPane;
    public JFXButton btnSTDClinic;
    public AnchorPane wellBabyPane;
    public JFXButton btnWellBabyClinic;
    public AnchorPane peadiatricPan;
    public JFXButton btnpeadiatricClinic;
    public AnchorPane GynObsclinicPane;
    public JFXButton btnGynObsClinic;
    public AnchorPane FamilyMedicalPane;
    public JFXButton btnfamilyMedicalClinic;
    public AnchorPane CanserPan;
    public JFXButton btnCanserClinic;
    public Button btnBack;
    public ScrollPane ClinicFormContext;

    public void OpenEyeClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/EyeClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenENTClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/ENTClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenSurgicalClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/SurgicalClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenMedicalClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/MedicalClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenSTDClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/STDClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenWellBabyClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/WellBabyClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenpeadiatricClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/PeadiatricClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenGynObslinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/GynObsClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenfamilyMedicalClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/FamilyMedicalClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenCanserClinicLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/CancerClinicLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void LoadDashBoard(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/DashBoard.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage =(Stage) ClinicFormContext.getScene().getWindow();
        Scene scene = new Scene(load);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);

    }
}
