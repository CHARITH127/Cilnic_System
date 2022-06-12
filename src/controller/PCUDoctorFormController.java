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
import model.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PCUDoctorFormController {
    public AnchorPane PCUContext;
    public Label lbldate;
    public JFXTextField txtPatientID;
    public JFXButton btnPCUSearch;
    public JFXTextField txtPatientName;
    public JFXTextField txtPatientAge;
    public JFXTextArea txtReason;
    public JFXTextArea txtIllness;
    public JFXTextArea txtMedicine;
    public RadioButton rdbHAvetoAdmit;
    public RadioButton rdbAttendClinic;
    public JFXComboBox cmbClinics;
    public JFXButton btnPCUAttend;
    public JFXButton btnPCUCasel;
    public ToggleGroup option;
    public Label lbldoctorID;
    public JFXTextArea txtReports;
    public Date date;
    public String clinicName;
    public Label lblSection;
    public RadioButton rbtGohome;

    public void initialize(){
        LoadDate.loadDate(lbldate);
        cmbClinics.setDisable(true);
        LoadClinicNames();
        btnPCUAttend.setDisable(true);

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

    public void LoadPatientDetails(ActionEvent actionEvent) {
        String id = txtPatientID.getText();
        PtientDetailsInSections patient = null;
        try {
            patient = new PCUPatientController().getPatient(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (patient==null){
            new Alert(Alert.AlertType.WARNING, "Empty Result Set").show();
        }else{
            txtPatientID.setText(patient.getPatientID());
            txtPatientName.setText(patient.getPatientName());
            txtPatientAge.setText(String.valueOf(patient.getAge()));
            txtReason.setText(patient.getReason());
        }
    }
    

    public void SaveDetailsSpesificClinicTable(ActionEvent actionEvent) {

        ArrayList<PatientHistory> histories= new ArrayList<>();

        histories.add(new PatientHistory(
                date,
                clinicName,
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtReason.getText(),
                txtIllness.getText(),
                txtReports.getText(),
                txtMedicine.getText(),
                lbldoctorID.getText(),
                "pcu"
        ));

        ClinicPatient patient = new ClinicPatient(
                date,
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtReason.getText(),
                txtIllness.getText(),
                txtReports.getText(),
                txtMedicine.getText(),
                lbldoctorID.getText(),
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

    }

    public void getOption(ActionEvent actionEvent) {
        SearchPatien patien = new SearchPatien(
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtReason.getText(),
                txtIllness.getText(),
                txtReports.getText(),
                txtMedicine.getText()
        );


        if (rbtGohome.isSelected()) {
            /*delete patient method*/
            try {
                if (new PatientTransferAdmitPCU().deletepatientOnPCU(txtPatientID.getText())) {
                    new Alert(Alert.AlertType.CONFIRMATION,"Removing successfull..").showAndWait();
                    clearAll();
                }else {
                    new Alert(Alert.AlertType.CONFIRMATION,"Can't Remove Please Try Again..").showAndWait();
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }else if(rdbHAvetoAdmit.isSelected()){
            /*send patient to admit room*/
            sendToSearchAddmitionRoom(patien);
            clearAll();

        }else if (rdbAttendClinic.isSelected()){
            cmbClinics.setDisable(false);
            btnPCUAttend.setDisable(false);
        }

    }

    public void sendToSearchAddmitionRoom(SearchPatien patien){

        if (new PatientTransferAdmitPCU().addPatientToSearchAdmissionRoom(patien)) {
            new Alert(Alert.AlertType.CONFIRMATION,"Patient successfully send.. ").showAndWait();
        }else {
            new Alert(Alert.AlertType.ERROR,"Try again..").showAndWait();
        }
    }


    public void clearAll(){
        txtPatientID.clear();
        txtPatientName.clear();
        txtPatientAge.clear();
        txtReason.clear();
        txtIllness.clear();
        txtReports.clear();
        txtMedicine.clear();
        rbtGohome.setSelected(false);
        rdbAttendClinic.setSelected(false);
        rdbHAvetoAdmit.setSelected(false);
    }

    public void setDoctorID(String id){
        lbldoctorID.setText(id);
    }
}
