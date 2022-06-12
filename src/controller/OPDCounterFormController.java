package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Patient;
import util.Validations;

import javax.xml.soap.Text;
import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class OPDCounterFormController {
    public TextField txtPatientID;
    public TextField txtPatientAge;
    public TextField txtPatientName;
    public TextArea txtPatientReason;
    public TextField txtStewardName;
    public TextField txtStewardtele;
    public Label lblRoomNumber;
    public Label lblDate;
    public JFXButton btnaddPatient;
    int roomNumber=1;

    LinkedHashMap<TextInputControl, Pattern> map = new LinkedHashMap();

    Pattern idPattern = Pattern.compile("^[0-9]{1,6}(V|)$");
    Pattern agePattern = Pattern.compile("^[0-9]{2}$");
    Pattern namePattern = Pattern.compile("^[A-z ]{3,20}$");
    Pattern resonPattern = Pattern.compile("^[a-zA-Z0-9\\.,\\s]+$");
    Pattern stewNAmePattern = Pattern.compile( "^[A-z ]{3,20}$");
    Pattern stewTelNumberPattern = Pattern.compile("^[0-9]{4,10}$");



    public void initialize(){
        loadDate();
        roomNumber=Integer.parseInt(lblRoomNumber.getText());
        btnaddPatient.setDisable(true);
        storeValidation();

    }

    private void storeValidation() {
        map.put(txtPatientID,idPattern);
        map.put(txtPatientAge,agePattern);
        map.put(txtPatientName,namePattern);
        map.put( txtPatientReason,resonPattern);
        map.put(txtStewardName,stewNAmePattern);
        map.put(txtStewardtele,stewTelNumberPattern);
    }

    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));
    }


    public void AddPatient(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        Patient patient = new Patient(
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtPatientReason.getText(),
                txtStewardName.getText(),
                Integer.parseInt(txtStewardtele.getText())
        );

        if (new OPDPatientController().addPatient(patient)){
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
            if(roomNumber<6){
                roomNumber++;
                lblRoomNumber.setText(String.valueOf(roomNumber));
            }else{
                roomNumber=1;
                lblRoomNumber.setText(String.valueOf(roomNumber));
            }
            txtPatientID.clear();
            txtPatientName.clear();
            txtPatientAge.clear();
            txtPatientReason.clear();
            txtStewardName.clear();
            txtStewardtele.clear();
        }else{
            new Alert(Alert.AlertType.ERROR, "Try again...").show();

        }
    }



    public void textFields_key_Released(KeyEvent keyEvent) {
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
