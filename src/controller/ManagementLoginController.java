package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ManagementLoginController {
    public AnchorPane ManagementLoginContext;
    public JFXTextField txtManagementUserName;
    public JFXPasswordField txtManagemntPassword;
    public JFXButton btnManagemntLogin;

    public void logInToManagemnt(ActionEvent actionEvent) throws IOException {
        if (txtManagemntPassword.getText().equals(new LoginController().loginControllerForManagemnt(txtManagementUserName.getText()))){
            URL resource = getClass().getResource("../view/ManagemntForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage stage = new Stage();
            stage =(Stage) ManagementLoginContext.getScene().getWindow();
            stage.setScene(new Scene(load));
        }else {
            new Alert(Alert.AlertType.ERROR,"Invalied Login ID Or Passord please ReEnter....").showAndWait();
        }


    }
}
