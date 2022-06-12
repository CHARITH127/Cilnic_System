package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Doctor;

import javax.print.Doc;
import java.sql.SQLException;

public class UpdateDoctorsController {
    public JFXTextField txtDoctorID;
    public JFXTextField txtDoctorName;
    public JFXTextField txtDoctorSpecializeArea;
    public JFXTextField txtDoctorTel;
    public JFXTextField txtDoctorPAssword;
    public JFXButton btnAddDoctor;
    public JFXButton btnCansel;
    public JFXButton btnSearchDoctor;

    public void AddDoctorsToDatabase(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Doctor doctor= new Doctor(
                txtDoctorID.getText(),
                txtDoctorName.getText(),
                Integer.parseInt(txtDoctorTel.getText()),
                txtDoctorSpecializeArea.getText(),
                txtDoctorPAssword.getText()
                );

        if (new DoctorController().UpdateDoctor(doctor)){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated..").show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again").show();
        }

        txtDoctorID.clear();
        txtDoctorName.clear();
        txtDoctorTel.clear();
        txtDoctorSpecializeArea.clear();
        txtDoctorPAssword.clear();
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
