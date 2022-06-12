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

public class LoginReceptionistController {
    public AnchorPane LOginiReceptionContext;
    public JFXPasswordField txtReceptionPassword;
    public JFXTextField txtReceptionUserName;
    public JFXButton btnReceptionLogin;

    public void logInToReception(ActionEvent actionEvent) throws IOException {

        if (txtReceptionPassword.getText().equals(new LoginController().loginControllerForReceptions(txtReceptionUserName.getText()))){
            URL resource = getClass().getResource("../view/ReceptionForm.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage stage = new Stage();
            stage =(Stage) LOginiReceptionContext.getScene().getWindow();
            stage.setScene(new Scene(load));
        }else {
            new Alert(Alert.AlertType.ERROR,"Invaild loginID or Password please re Enter").showAndWait();
        }


    }
}
