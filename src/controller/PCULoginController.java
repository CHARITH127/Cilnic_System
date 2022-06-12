package controller;

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

public class PCULoginController {
    public AnchorPane PCULoginContext;
    public JFXTextField txtPCUUserName;
    public JFXPasswordField txtPCUPassword;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void logInToPCU(ActionEvent actionEvent) throws IOException {
        if (txtPCUPassword.getText().equals(new LoginController().loginControllerForDoctors(txtPCUUserName.getText()))){

            String userID = txtPCUUserName.getText();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PCUDoctorForm.fxml"));
            root = loader.load();

            PCUDoctorFormController pcuDoctorFormController = loader.getController();
            pcuDoctorFormController.setDoctorID(userID);

            stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{
            new Alert(Alert.AlertType.ERROR,"Invalied DoctorID Or Passwor Please Try  Again ").showAndWait();
        }

    }
}
