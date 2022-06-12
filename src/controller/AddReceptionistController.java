package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Reception;

import java.sql.SQLException;

public class AddReceptionistController {
    public JFXTextField txtDoctorID;
    public JFXTextField txtDoctorName;
    public JFXTextField txtDoctorTel;
    public JFXTextField txtDoctorPAssword;
    public JFXButton btnReception;

    public void AddReceptionistToTheTable(ActionEvent actionEvent) {
        Reception  reception = new Reception(
                txtDoctorID.getText(),
                txtDoctorName.getText(),
                Integer.parseInt(txtDoctorTel.getText()),
                txtDoctorPAssword.getText()
        );

        try {
            if (new ReceptionController().AddReception(reception)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Adding Successfull").showAndWait();
                clearAll();

            }else{
                new Alert(Alert.AlertType.ERROR,"Try Again").showAndWait();

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clearAll() {
        txtDoctorID.clear();
        txtDoctorName.clear();
        txtDoctorTel.clear();
        txtDoctorPAssword.clear();
    }
}
