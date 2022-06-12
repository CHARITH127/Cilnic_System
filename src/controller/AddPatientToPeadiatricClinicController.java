package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.ClinicPatient;
import model.LoadDate;
import model.PatientHistory;
import model.PatientReference;
import util.Validations;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AddPatientToPeadiatricClinicController {
    public AnchorPane AddPatientClinicPan;
    public TextField txtAddPatientID;
    public TextField txtAddPatientName;
    public TextField txtAddPatientAge;
    public TextArea txtAddPatientReason;
    public TextArea txtAddPatientIllness;
    public TextArea txtAddPatientReports;
    public TextArea txtAddPatientMedicine;
    public JFXButton btnAddPatientADD;
    public JFXButton btnAddPAtientCanel;
    public TextField txtAddDoctorID;
    public TextField txtStewardName;
    public TextField txtStewardTel;
    public Label lblClinicName;
    public Label lblDate;
    public Date date;

    LinkedHashMap<TextInputControl, Pattern> map = new LinkedHashMap();

    Pattern doctorIdPattern = Pattern.compile("^[D][-][0-9]{1,4}$");
    Pattern idPattern = Pattern.compile("^[0-9]{1,6}(V|)$");
    Pattern agePattern = Pattern.compile("^[0-9]{2}$");
    Pattern namePattern = Pattern.compile("^[A-z ]{3,20}$");
    Pattern resonPattern = Pattern.compile("^[a-zA-Z0-9\\.,\\s]+$");
    Pattern illnessPattern = Pattern.compile("^[a-zA-Z0-9\\.,\\s]+$");
    Pattern ReportsPattern = Pattern.compile("^[a-zA-Z0-9\\.,\\s]+$");
    Pattern medicinePattern = Pattern.compile("^[a-zA-Z0-9\\.,\\s]+$");
    Pattern stewNAmePattern = Pattern.compile( "^[A-z ]{3,20}$");
    Pattern stewTelNumberPattern = Pattern.compile("^[0-9]{4,10}$");

    public void initialize(){

        LoadDate.loadDate(lblDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = lblDate.getText();
        storeValidation();

        try {

            date = formatter.parse(dateInString);
            System.out.println(formatter.format(date));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void storeValidation() {
        map.put(txtAddDoctorID,doctorIdPattern);
        map.put(txtAddPatientID,idPattern);
        map.put(txtAddPatientAge,agePattern);
        map.put(txtAddPatientName,namePattern);
        map.put( txtAddPatientReason,resonPattern);
        map.put( txtAddPatientIllness,illnessPattern);
        map.put( txtAddPatientReports,ReportsPattern);
        map.put( txtAddPatientMedicine,medicinePattern);
        map.put(txtStewardName,stewNAmePattern);
        map.put(txtStewardTel,stewTelNumberPattern);
    }

    public void AddPAtientToTheClinic(ActionEvent actionEvent) {

        ArrayList<PatientHistory> patientHistories = new ArrayList<>();

        patientHistories.add(new PatientHistory(
                date,
                lblClinicName.getText(),
                txtAddPatientID.getText(),
                txtAddPatientName.getText(),
                Integer.parseInt(txtAddPatientAge.getText()),
                txtAddPatientReason.getText(),
                txtAddPatientIllness.getText(),
                txtAddPatientReports.getText(),
                txtAddPatientMedicine.getText(),
                txtAddDoctorID.getText(),
                lblClinicName.getText()
        ));

        ClinicPatient patient = new ClinicPatient(
                date,
                txtAddPatientID.getText(),
                txtAddPatientName.getText(),
                Integer.parseInt(txtAddPatientAge.getText()),
                txtAddPatientReason.getText(),
                txtAddPatientIllness.getText(),
                txtAddPatientReports.getText(),
                txtAddPatientMedicine.getText(),
                txtAddDoctorID.getText(),
                patientHistories
        );

        PatientReference reference = new PatientReference(
                txtAddPatientID.getText(),
                txtAddPatientName.getText(),
                Integer.parseInt(txtAddPatientAge.getText()),
                txtStewardName.getText(),
                Integer.parseInt(txtStewardTel.getText())
        );


        if (new PatientInPeadiatricClinic().addPatientDirectly(patient)) {
            try {
                if (new PatientInPeadiatricClinic().upDatePatientRefernece(reference)) {
                    new Alert(Alert.AlertType.CONFIRMATION,"SuceessFully add..").showAndWait();
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
    }

    public void clearAll(){
        txtAddDoctorID.clear();
        txtAddPatientID.clear();
        txtAddPatientName.clear();
        txtAddPatientAge.clear();
        txtAddPatientReason.clear();
        txtAddPatientIllness.clear();
        txtAddPatientReports.clear();
        txtAddPatientMedicine.clear();
        txtStewardName.clear();
        txtStewardTel.clear();
    }

    public void on_key_released(KeyEvent keyEvent) {

        Object response = Validations.validate(map, btnAddPatientADD);


        if (keyEvent.getSource() == KeyCode.ENTER) {
            if (response instanceof TextInputControl) {
                TextInputControl errorText = (TextInputControl) response;
                errorText.requestFocus();
            }else if(response instanceof Boolean){
                new Alert(Alert.AlertType.INFORMATION, "Aded").showAndWait();
            }
        }
    }

    public void stageClose(ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddPAtientCanel.getScene().getWindow();
        stage.close();
    }
}
