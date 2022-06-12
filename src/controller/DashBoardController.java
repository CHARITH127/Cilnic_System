package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class DashBoardController {
    public AnchorPane DashBoardContext;
    public Pane dashboardPane;
    public JFXButton btnContinue;
    public VBox Vbox;

    public void initialize(){
        TranslateTransition slide= new TranslateTransition();
        slide.setDuration(Duration.seconds(1));
        slide.setNode(Vbox);
        slide.setToX(Vbox.getLayoutX()*28);
        slide.play();
        Vbox.setTranslateX(-176);
        slide.setOnFinished(event -> {

        });
        Vbox.setTranslateX(-1000);
    }

    public void SlideThePicture(ActionEvent actionEvent) {
        TranslateTransition slide= new TranslateTransition();
        slide.setDuration(Duration.seconds(1));
        slide.setNode(Vbox);
        slide.setToX(0);
        slide.play();
        Vbox.setTranslateX(-176);
        slide.setOnFinished(event -> {

        });
        Vbox.setTranslateX(1000);
    }

    public void CloseTheSoftware(ActionEvent actionEvent) {
        System.exit(0);

    }

    public void OpenReseptionLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/LoginReceptionist.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void OpnOPDLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/OPDLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void OpenPCULogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/PCULogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void OpenAdmitionLogin(ActionEvent actionEvent) throws IOException {
        Parent load =FXMLLoader.load(getClass().getResource("../view/LoginAdmissionRoom.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    public void OpenManagmentLogin(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/ManagementLogin.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void OpenClinicUi(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ClinicForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = new Stage();
        stage =(Stage) DashBoardContext.getScene().getWindow();
        stage.setScene(new Scene(load));
    }
}
