package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AdmitPatient;
import model.ClinicPatient;
import model.LoadDate;
import model.PatientHistory;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdmitRoomDoctorFormController {
    public AnchorPane AdmitContext;
    public Label lbldate;
    public JFXTextField patientiD;
    public JFXButton btnAdmitSearch;
    public JFXTextField patientName;
    public JFXTextField patientAge;
    public JFXTextArea txtPatientReson;
    public JFXTextArea txtPatientIllness;
    public JFXTextArea txtPatientMedicine;
    public RadioButton rdbAttendClinic;
    public JFXComboBox cmbClinics;
    public JFXButton btnAdmitAttend;
    public JFXButton btnAdmitCasel;
    public JFXButton btnAdmitUpdate;
    public JFXTextField patientBedNumbr;
    public JFXTextField patientWordNumber;
    public ToggleGroup options;
    public Label lblDoctorID;
    public JFXTextArea txtReports;
    public JFXTextField txtWordNUmber;
    public RadioButton rbtGoHome;
    public Label lblSection;
    public String clinicName;
    public Date date;

    public void initialize(){
        LoadDate.loadDate(lbldate);
        cmbClinics.setDisable(true);
        LoadClinicNames();
        btnAdmitAttend.setDisable(true);
        btnAdmitUpdate.setDisable(true);

        /*Listners Area==============================================================*/
        cmbClinics.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            clinicName = (String) newValue;
        });

        /*Listners Area==============================================================*/


        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = lbldate.getText();

        try {

            date = formatter.parse(dateInString);
            System.out.println(formatter.format(date));


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void LoadPatientDetails(ActionEvent actionEvent) {

        String text = patientiD.getText();

        try {
            AdmitPatient patientDetails = new AdmitPatientController().getPatientDetails(text);

            if (patientDetails==null){
                new Alert(Alert.AlertType.ERROR,"Empty result set..").showAndWait();
            }else {
                patientiD.setText(patientDetails.getPatientID());
                patientName.setText(patientDetails.getPatientName());
                patientAge.setText(String.valueOf(patientDetails.getPatientAge()));
                txtPatientReson.setText(patientDetails.getReason());
                txtReports.setText(patientDetails.getReports());
                txtPatientIllness.setText(patientDetails.getIllnes());
                txtPatientMedicine.setText(patientDetails.getMedicine());
                txtWordNUmber.setText(String.valueOf(patientDetails.getWordnum()));
                patientBedNumbr.setText(String.valueOf(patientDetails.getBedNUm()));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        btnAdmitUpdate.setDisable(false);
    }

    private void LoadClinicNames() {
        ArrayList<String> clinicNames = new ArrayList<>();
        clinicNames.add("Eye");
        clinicNames.add("ENT");
        clinicNames.add("Surgical");
        clinicNames.add("Medical");
        clinicNames.add("STD");
        clinicNames.add("Well Baby");
        clinicNames.add("Peadiatric");
        clinicNames.add("Gyn & Obs");
        clinicNames.add("Family Medical");
        clinicNames.add("Canser");

        cmbClinics.getItems().setAll(clinicNames);

    }

    public void SaveDetailsSpesificClinicTable(ActionEvent actionEvent) {

        ArrayList<PatientHistory> histories= new ArrayList<>();
        histories.add(new PatientHistory(
                date,
                clinicName,
                patientiD.getText(),
                patientName.getText(),
                Integer.parseInt(patientAge.getText()),
                txtPatientReson.getText(),
                txtPatientIllness.getText(),
                txtReports.getText(),
                txtPatientMedicine.getText(),
                lblDoctorID.getText(),
                lblSection.getText()
        ));

        ClinicPatient patient = new ClinicPatient(
                date,
                patientiD.getText(),
                patientName.getText(),
                Integer.parseInt(patientAge.getText()),
                txtPatientReson.getText(),
                txtPatientIllness.getText(),
                txtReports.getText(),
                txtPatientMedicine.getText(),
                lblDoctorID.getText(),
                histories

        );
        if (clinicName.equalsIgnoreCase("Eye")){
            if (new PatientInEyeClinic().addPatientInToTheClinic(patient)){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("ENT")){
            if (new PatientInENTClinic().addPatientInToTheClinic(patient)){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            }else {
                new Alert(Alert.AlertType.WARNING,"Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("Surgical")) {
            if (new PatientInSurgicalClinic().addPatientInToTheClinic(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("Medical")) {
            if (new PatientInMedicalClinic().addPatientInToTheClinic(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("STD")) {
            if (new PatientInSTDClinic().addPatientInToTheClinic(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("Well Baby")) {
            if (new PatientInWellBabyClinic().addPatientInToTheClinic(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("Peadiatric")) {
            if (new PatientInPeadiatricClinic().addPatientInToTheClinic(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("Gyn & Obs")) {
            if (new PatientInGynObsClinic().addPatientInToTheClinic(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("Family Medical")) {
            if (new PatientInFamilyMedicalClinic().addPatientInToTheClinic(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
        }else if(clinicName.equalsIgnoreCase("Canser")) {
            if (new PatientInCancerClinic().addPatientInToTheClinic(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").showAndWait();
                clearAll();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again..").show();
            }
        }else {
            return;
        }
    }

    public void GoToDashBoard(ActionEvent actionEvent) {
        Stage stage = (Stage) btnAdmitCasel.getScene().getWindow();
        stage.close();
    }

    public void savePatientDetailsOnAdmitTable(ActionEvent actionEvent) {

        AdmitPatient patient = new AdmitPatient(
                patientiD.getText(),
                patientName.getText(),
                Integer.parseInt(patientAge.getText()),
                txtPatientReson.getText(),
                txtPatientIllness.getText(),
                txtReports.getText(),
                txtPatientMedicine.getText(),
                Integer.parseInt(txtWordNUmber.getText()),
                Integer.parseInt(patientBedNumbr.getText())
        );

        try {
            if (new AdmitPatientController().updatePatient(patient)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Sucessfully Updated..").showAndWait();
            }else {
                new Alert(Alert.AlertType.ERROR,"Try Again").show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void GetOption(ActionEvent actionEvent) {

        /* This method is delared the radion button options */


        if (rbtGoHome.isSelected()){
            try {
                if (new AdmitPatientController().deletePatientofAdmitionRoom(patientiD.getText())) {
                    if (new AdmitPatientController().deletePatientofReferal(patientiD.getText())) {
                        if (new AdmitPatientController().delePatientOnHistory(patientiD.getText())) {
                            new Alert(Alert.AlertType.CONFIRMATION,"Removing complete..").showAndWait();
                        }else {
                            new Alert(Alert.AlertType.WARNING,"Try Again..").showAndWait();
                        }
                    }else {
                        new Alert(Alert.AlertType.WARNING,"Try Again..").showAndWait();
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            clearAll();
        }else if (rdbAttendClinic.isSelected()){
            cmbClinics.setDisable(false);
            btnAdmitAttend.setDisable(false);
        }
    }

    private void clearAll() {
        patientiD.clear();
        patientName.clear();
        patientAge.clear();
        txtPatientReson.clear();
        txtReports.clear();
        txtPatientIllness.clear();
        txtPatientMedicine.clear();
        txtWordNUmber.clear();
        patientBedNumbr.clear();
        rdbAttendClinic.setSelected(false);
        rbtGoHome.setSelected(false);
        btnAdmitAttend.setDisable(true);
    }

    public void setDoctorID(String id){
        lblDoctorID.setText(id);
    }
}
