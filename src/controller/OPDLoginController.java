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

public class OPDLoginController {
    public JFXTextField txtOPDUserName;
    public JFXPasswordField txtOPDPassword;
    public AnchorPane OPDLoginContext;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void logInToOPD(ActionEvent actionEvent) throws IOException {

        if (txtOPDPassword.getText().equals(new LoginController().loginControllerForDoctors(txtOPDUserName.getText()))){

            String userID = txtOPDUserName.getText();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/OPDDoctorForm.fxml"));
            root = loader.load();

            OPDDoctorFormController opdDoctorFormController = loader.getController();
            opdDoctorFormController.setdoctorID(userID);

            stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{
            new Alert(Alert.AlertType.ERROR,"Invalied DoctorID Or Passwor Please Try  Again ").showAndWait();
        }


    }
}
