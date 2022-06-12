package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginAdmissionRoomController {
    public JFXTextField txtAdmissionUserName;
    public JFXPasswordField txtAdmissionPassword;
    public JFXButton btnAdmissionRoomLogin;
    public AnchorPane AdmissionContext;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void logInToAdmissionRoom(ActionEvent actionEvent) throws IOException {
        if (txtAdmissionPassword.getText().equals(new LoginController().loginControllerForDoctors(txtAdmissionUserName.getText()))){

            String userID = txtAdmissionUserName.getText();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AdmitRoomDoctorForm.fxml"));
            root = loader.load();

            AdmitRoomDoctorFormController admitRoomDoctorFormController = loader.getController();
            admitRoomDoctorFormController.setDoctorID(userID);

            stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Invalied DoctorID Or Passwor Please Try  Again ").showAndWait();
        }

    }
}
