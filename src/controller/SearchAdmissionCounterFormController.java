package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.AdmitPatient;
import model.Patient;
import model.PatientReference;
import model.SearchPatien;
import org.omg.PortableInterceptor.INACTIVE;
import util.Validations;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class SearchAdmissionCounterFormController {
    public AnchorPane SearchAdmitionRoomContext;
    public TextField txtPatientID;
    public TextField txtPatientAge;
    public TextField txtPatientName;
    public TextArea txtPatientReason;
    public TextField txtStewardName;
    public TextField txtStewardtele;
    public JFXButton btnaddPatient;
    public TextField txtWordNumber;
    public TextField txtBedNumber;
    public JFXButton btnSearchPatient;
    public TextArea txtPatientIlness;
    public TextArea txtPatientMedicine;
    public TextArea txtPatientReports;

    LinkedHashMap<TextInputControl, Pattern> map = new LinkedHashMap<>();
    Pattern wordPattern = Pattern.compile("^[0-9]{1,3}$");
    Pattern bedPattern = Pattern.compile("^[0-9]{1,3}$");

    public void initialize(){
        btnaddPatient.setDisable(true);
        storeValidation();
    }

    private void storeValidation() {
        map.put(txtWordNumber,wordPattern);
        map.put(txtBedNumber,bedPattern);
    }

    public void AddPatient(ActionEvent actionEvent) {
        AdmitPatient admitPatient = new AdmitPatient(
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtPatientReason.getText(),
                txtPatientReports.getText(),
                txtPatientIlness.getText(),
                txtPatientMedicine.getText(),
                Integer.parseInt(txtWordNumber.getText()),
                Integer.parseInt(txtBedNumber.getText())
        );

        try {
            if (new AdmitPatientController().admitPatient(admitPatient)) {
                if (new AdmitPatientController().deleteSearchAdmition(txtPatientID.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION,"Adding successfull..").showAndWait();
                    clearAll();
                }

            }else {
                new Alert(Alert.AlertType.ERROR,"Try again..").showAndWait();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clearAll() {
        txtPatientID.clear();
        txtPatientAge.clear();
        txtPatientName.clear();
        txtPatientReason.clear();
        txtPatientIlness.clear();
        txtPatientReports.clear();
        txtPatientMedicine.clear();
        txtStewardtele.clear();
        txtStewardName.clear();
        txtWordNumber.clear();
        txtBedNumber.clear();
    }

    public void searchPatientDetails(ActionEvent actionEvent) {

        try {
            SearchPatien patien = new AdmitPatientController().loadPationOnSearchAdmission(txtPatientID.getText());
            PatientReference referel = new AdmitPatientController().getPationReferel(txtPatientID.getText());

            if (patien == null) {
                new Alert(Alert.AlertType.ERROR,"Empty set").showAndWait();
            }else {
                txtPatientID.setText(patien.getPatienID());
                txtPatientName.setText(patien.getPatientName());
                txtPatientAge.setText(String.valueOf(patien.getPatientAge()));
                txtPatientReason.setText(patien.getReason());
                txtPatientIlness.setText(patien.getIllness());
                txtPatientReports.setText(patien.getReports());
                txtPatientMedicine.setText(patien.getMedicine());
                txtStewardName.setText(referel.getStewName());
                txtStewardtele.setText(String.valueOf(referel.getStewTel()));
            }




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void on_key_released(KeyEvent keyEvent) {
        Object response = Validations.validate(map, btnaddPatient);

        if (keyEvent.getSource() == KeyCode.ENTER) {
            if (response instanceof TextInputControl) {
                TextInputControl errorText = (TextInputControl) response;
                errorText.requestFocus();
            }else if(response instanceof Boolean){
                new Alert(Alert.AlertType.INFORMATION, "Aded").showAndWait();
            }
        }
    }
}
