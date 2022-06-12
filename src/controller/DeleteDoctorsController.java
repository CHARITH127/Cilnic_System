package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Doctor;

import java.sql.SQLException;

public class DeleteDoctorsController {
    public JFXTextField txtDoctorTel;
    public JFXTextField txtDoctorID;
    public JFXTextField txtDoctorName;
    public JFXTextField txtDoctorSpecializeArea;
    public JFXTextField txtDoctorPAssword;
    public JFXButton btnDeleteDoctor;
    public JFXButton btnCansel;
    public JFXButton btnSearchDoctor;

    public void DeleteDoctorsToDatabase(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        if (new DoctorController().deleteDoctor(txtDoctorID.getText())) {
            new Alert(Alert.AlertType.CONFIRMATION, "Do you want to delete this doctor ?").showAndWait();
            txtDoctorID.clear();
            txtDoctorName.clear();
            txtDoctorTel.clear();
            txtDoctorSpecializeArea.clear();
            txtDoctorPAssword.clear();
        }else{
            new Alert(Alert.AlertType.ERROR, "Try Again").show();
        }
    }

    public void SearchDoctors(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String ID = txtDoctorID.getText();

        Doctor doctor = new DoctorController().getDoctor(ID);
        if (doctor==null){
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        }else{
            txtDoctorID.setText(doctor.getDoctorID());
            txtDoctorName.setText(doctor.getDoctorName());
            txtDoctorSpecializeArea.setText(doctor.getSpecializeArea());
            txtDoctorTel.setText(String.valueOf(doctor.getTelephoneNumber()));
            txtDoctorPAssword.setText(doctor.getPassword());
        }
    }
}
