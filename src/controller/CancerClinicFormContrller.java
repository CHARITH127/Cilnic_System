package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ClinicPatient;
import model.LoadDate;
import model.PatientHistory;
import model.SearchPatien;
import view.tm.PatienHistoryTm;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class CancerClinicFormContrller {
    public AnchorPane CancerClinicContext;
    public AnchorPane headBarContext;
    public Button btnAddPatient;
    public Button btnGoBack;
    public AnchorPane DoctorIdPane;
    public Label lblClinicDoctorID;
    public Label lblClinicDate;
    public AnchorPane patientPan;
    public TextField txtPatientName;
    public Button btnPtientSearch;
    public TextField txtPatientID;
    public TextField txtPatientAge;
    public TextArea txtPatientReason;
    public TextArea txtPatientReports;
    public TextArea txtPatientMedicines;
    public TextField txtPatientIllness;
    public AnchorPane patientHistoryPan;
    public Button btnPtientHistorySearch;
    public TextField txtpatientHistorySearch;
    public TableView tblEyeClinicPatiantHistory;
    public TableColumn colDate;
    public TableColumn colReports;
    public TableColumn colMedicine;
    public TableColumn colDoctorID;
    public JFXButton btnCancerClinicAdmit;
    public JFXButton btnCancerClinicGoHome;
    public JFXButton btnCancerClinicUpdate;
    public Date date;
    public DatePicker datePicker;
    public String selectdate;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize(){

        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colReports.setCellValueFactory(new PropertyValueFactory<>("reports"));
        colMedicine.setCellValueFactory(new PropertyValueFactory<>("medcine"));
        colDoctorID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));


        LoadDate.loadDate(lblClinicDate);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = lblClinicDate.getText();

        try {

            date = formatter.parse(dateInString);
            System.out.println(formatter.format(date));


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void AddPatientsToClinics(ActionEvent actionEvent) throws IOException {

        String doctorID = lblClinicDoctorID.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddPatientToCancerClinic.fxml"));
        root=loader.load();
        AddPatientToCanserClinicController patient = loader.getController();
        patient.txtAddDoctorID.setText(doctorID);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    public void GoToClinicForm(ActionEvent actionEvent) {
    }

    public void SearchOnPatientHistory(ActionEvent actionEvent) {

        try {
            ObservableList<PatienHistoryTm> patientHistory =
                    new PatientInCancerClinic().getPatientHistory(txtpatientHistorySearch.getText());
            tblEyeClinicPatiantHistory.setItems(patientHistory);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ToAdmit(ActionEvent actionEvent) {

        SearchPatien patien = new SearchPatien(
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtPatientReason.getText(),
                txtPatientIllness.getText(),
                txtPatientReports.getText(),
                txtPatientMedicines.getText()
        );

        try {
            if (new PatientInCancerClinic().addPatientToSearchAdmission(patien)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Successfully send ").showAndWait();

            }else{
                new Alert(Alert.AlertType.WARNING,"Try again").showAndWait();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        new ReportsConroller().showAdmitRport(txtPatientID.getText(),
                txtPatientName.getText(),txtPatientAge.getText(),txtPatientReason.getText(),txtPatientIllness.getText(),
                txtPatientReports.getText(),txtPatientMedicines.getText(),lblClinicDoctorID.getText(),date);

        clearAll();
    }

    public void DeleteThePatientDetails(ActionEvent actionEvent) {

        try {
            if (new PatientInCancerClinic().deletePatientOnClinic(txtPatientID.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION,"Removing Successfull").showAndWait();
                clearAll();
            }else{
                new Alert(Alert.AlertType.ERROR,"Try again").showAndWait();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void UpdateTheClinicTable(ActionEvent actionEvent) {

        ArrayList<PatientHistory> histories = new ArrayList<>();
        histories.add(new PatientHistory(
                date,
                "Cancer",
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtPatientReason.getText(),
                txtPatientIllness.getText(),
                txtPatientReports.getText(),
                txtPatientMedicines.getText(),
                lblClinicDoctorID.getText(),
                "Cancer"
        ));

        ClinicPatient patient= new ClinicPatient(
                date,
                txtPatientID.getText(),
                txtPatientName.getText(),
                Integer.parseInt(txtPatientAge.getText()),
                txtPatientReason.getText(),
                txtPatientIllness.getText(),
                txtPatientReports.getText(),
                txtPatientMedicines.getText(),
                lblClinicDoctorID.getText(),
                histories
        );
        if (new PatientInCancerClinic().updatePatient(patient)) {
            new Alert(Alert.AlertType.CONFIRMATION,"Updating Successfull..").showAndWait();
            clearAll();
        }else{
            new Alert(Alert.AlertType.ERROR,"Try Again..").showAndWait();
        }

        selectdate = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        new ReportsConroller().showUpdateReport("CANCER CLINIC",txtPatientID.getText(),
                txtPatientName.getText(),txtPatientAge.getText(),txtPatientReason.getText(),txtPatientIllness.getText(),
                txtPatientReports.getText(),txtPatientMedicines.getText(),lblClinicDoctorID.getText(),selectdate);

        clearAll();
    }

    public void loadPatient(ActionEvent actionEvent) {

        try {
            SearchPatien patient = new PatientInCancerClinic().getPatient(txtPatientID.getText());

            if (patient== null){
                new Alert(Alert.AlertType.ERROR,"Invalid patient ID").showAndWait();
            }else {
                txtPatientID.setText(patient.getPatienID());
                txtPatientName.setText(patient.getPatientName());
                txtPatientAge.setText(String.valueOf(patient.getPatientAge()));
                txtPatientReason.setText(patient.getReason());
                txtPatientIllness.setText(patient.getIllness());
                txtPatientReports.setText(patient.getReports());
                txtPatientMedicines.setText(patient.getMedicine());
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clearAll(){
        txtPatientID.clear();
        txtPatientName.clear();
        txtPatientAge.clear();
        txtPatientReason.clear();
        txtPatientIllness.clear();
        txtPatientReports.clear();
        txtPatientMedicines.clear();
        datePicker.getEditor().clear();
    }

    public void setDoctorID(String id){
        lblClinicDoctorID.setText(id);
    }
}
