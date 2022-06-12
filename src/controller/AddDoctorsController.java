package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Doctor;

import javax.swing.*;
import java.sql.SQLException;

public class AddDoctorsController {
    public JFXTextField txtDoctorID;
    public JFXTextField txtDoctorName;
    public JFXTextField txtDoctorSpecializeArea;
    public JFXTextField txtDoctorTel;
    public JFXTextField txtDoctorPAssword;
    public JFXButton btnAddDoctor;
    public JFXButton btnCansel;

    public void AddDoctorsToDatabase(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Doctor doctor = new Doctor(txtDoctorID.getText(),txtDoctorName.getText(),
                Integer.parseInt(txtDoctorTel.getText()),txtDoctorSpecializeArea.getText(),txtDoctorPAssword.getText());
        if (new DoctorController().AddDoctors(doctor)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }

        txtDoctorID.clear();
        txtDoctorName.clear();
        txtDoctorTel.clear();
        txtDoctorSpecializeArea.clear();
        txtDoctorPAssword.clear();
    }

}
