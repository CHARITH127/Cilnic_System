package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.AdmitPatient;
import model.LoadDate;
import model.PatientReference;
import util.Validations;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AdmissionCounterFormController {
    public Label lblDate;
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
    public TextArea txtPatientMedicine;
    public TextField txtPatientIllness;

    LinkedHashMap<TextInputControl, Pattern> map = new LinkedHashMap();

    Pattern idPattern = Pattern.compile("^[0-9]{1,6}(V|)$");
    Pattern agePattern = Pattern.compile("^[0-9]{2}$");
    Pattern namePattern = Pattern.compile("^[A-z ]{3,20}$");
    Pattern resonPattern = Pattern.compile("^[A-z ]{3,20}$");
    Pattern illnessPattern = Pattern.compile("^[A-z ]{3,20}$");
    Pattern medicinePattern = Pattern.compile("^[A-z ]{3,20}$");
    Pattern stewNAmePattern = Pattern.compile( "^[A-z ]{3,20}$");
    Pattern stewTelNumberPattern = Pattern.compile("^[0-9]{4,10}$");
    Pattern wordPattern = Pattern.compile("^[0-9]{1,3}$");
    Pattern bedPattern = Pattern.compile("^[0-9]{1,3}$");

    public void initialize(){
        LoadDate.loadDate(lblDate);
        btnaddPatient.setDisable(true);
        storeValidation();
    }
    private void storeValidation() {
        map.put(txtPatientID,idPattern);
        map.put(txtPatientAge,agePattern);
        map.put(txtPatientName,namePattern);
        map.put( txtPatientReason,resonPattern);
        map.put( txtPatientIllness,illnessPattern);
        map.put( txtPatientMedicine,medicinePattern);
        map.put(txtStewardName,stewNAmePattern);
        map.put(txtStewardtele,stewTelNumberPattern);
        map.put(txtWordNumber,wordPattern);
        map.put(txtBedNumber,bedPattern);
    }


    public void AddPatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        AdmitPatient patient = new AdmitPatient(
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtPatientReason.getText(),
                txtPatientIllness.getText(),
                "null",
                txtPatientMedicine.getText(),
                Integer.parseInt(txtWordNumber.getText()),
                Integer.parseInt(txtBedNumber.getText())
        );

        PatientReference reference = new PatientReference(
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtStewardName.getText(),
                Integer.parseInt(txtStewardtele.getText())
        );


        if (new AdmitPatientController().admitPatient(patient)) {
            if (new AdmitPatientController().addPatientReference(reference)) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
                txtPatientID.clear();
                txtPatientName.clear();
                txtPatientAge.clear();
                txtPatientIllness.clear();
                txtPatientReason.clear();
                txtPatientMedicine.clear();
                txtStewardtele.clear();
                txtStewardName.clear();
                txtWordNumber.clear();
                txtBedNumber.clear();
            }

        }else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        }



    }

    public void searchPatientDetails(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/SearchAdmissionRoomCounterForm.fxml"));
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
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
