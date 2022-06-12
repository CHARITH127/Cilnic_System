package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.LoadDate;
import model.Patient;
import model.PatientReference;
import util.Validations;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class PCUCounterFormController {
    public Label lblDate;
    public TextField txtPatientID;
    public TextField txtPatientAge;
    public TextField txtPatientName;
    public TextArea txtPatientReason;
    public TextField txtStewardName;
    public TextField txtStewardTel;
    public JFXButton btnaddPatient;

    LinkedHashMap<TextInputControl, Pattern> map = new LinkedHashMap();

    Pattern idPattern = Pattern.compile("^[0-9]{1,6}(V|)$");
    Pattern agePattern = Pattern.compile("^[0-9]{2}$");
    Pattern namePattern = Pattern.compile("^[A-z ]{3,20}$");
    Pattern resonPattern = Pattern.compile("^[a-zA-Z0-9\\.,\\s]+$");
    Pattern stewNAmePattern = Pattern.compile( "^[A-z ]{3,20}$");
    Pattern stewTelNumberPattern = Pattern.compile("^[0-9]{4,10}$");

    public void initialize(){
        LoadDate.loadDate(lblDate);
        storeValidation();
        btnaddPatient.setDisable(true);
    }

    private void storeValidation() {
        map.put(txtPatientID,idPattern);
        map.put(txtPatientAge,agePattern);
        map.put(txtPatientName,namePattern);
        map.put( txtPatientReason,resonPattern);
        map.put(txtStewardName,stewNAmePattern);
        map.put(txtStewardTel,stewTelNumberPattern);
    }

    public void AddPatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Patient patient = new Patient(
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtPatientReason.getText(),
                txtStewardName.getText(),
                Integer.parseInt(txtStewardTel.getText())
        );

        PatientReference reference = new PatientReference(
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtStewardName.getText(),
                Integer.parseInt(txtStewardTel.getText())
        );

        if (new PCUPatientController().addPatient(patient)){
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            txtPatientID.clear();
            txtPatientName.clear();
            txtPatientAge.clear();
            txtPatientReason.clear();
            txtStewardName.clear();
            txtStewardTel.clear();
        }else{
            new Alert(Alert.AlertType.ERROR, "Try again...").show();
        }

    }

    public void on_key_Released(KeyEvent keyEvent) {

        Object response = Validations.validate(map,btnaddPatient);


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
