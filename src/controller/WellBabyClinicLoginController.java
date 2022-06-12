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

public class WellBabyClinicLoginController {
    public AnchorPane WellBabyClinicLoginContext;
    public JFXTextField txtDoctorID;
    public JFXPasswordField txtDoctorPassword;
    public JFXButton btnLoginWellBabyClinic;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void GoToWellBabyClinic(ActionEvent actionEvent) throws IOException {
        if (txtDoctorPassword.getText().equals(new LoginController().loginControllerForDoctors(txtDoctorID.getText()))){

            String userID = txtDoctorID.getText();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/WellBabyClinicForm.fxml"));
            root = loader.load();

            WellBabyClinicFormContrller wellBabyClinicFormContrller = loader.getController();
            wellBabyClinicFormContrller.setDoctorID(userID);

            stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }else{
            new Alert(Alert.AlertType.ERROR,"Invalied DoctorID Or Passwor Please Try  Again ").showAndWait();
        }


    }
}
