package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import view.tm.ManagemntPatientDetailsTm;
import view.tm.ManagemntPatientHistoryTm;

import java.sql.SQLException;

public class PatientHistoryController {
    public TextField txtPatientHistoryID;
    public JFXButton btnSearch;
    public TableView lblPatientDetails;
    public TableColumn colPatientName;
    public TableColumn colPatientAge;
    public TableColumn colStewName;
    public TableColumn colStewTel;
    public TableView tblHistory;
    public TableColumn colClinicDate;
    public TableColumn colClinicName;
    public TableColumn colReason;
    public TableColumn colIllness;
    public TableColumn colReports;
    public TableColumn colMedicine;
    public TableColumn colDoctorID;


    public void initialize(){
        colPatientName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        colPatientAge.setCellValueFactory(new PropertyValueFactory<>("patientAge"));
        colStewName.setCellValueFactory(new PropertyValueFactory<>("StewardName"));
        colStewTel.setCellValueFactory(new PropertyValueFactory<>("stewTel"));
        colClinicDate.setCellValueFactory(new PropertyValueFactory<>("clincDate"));
        colClinicName.setCellValueFactory(new PropertyValueFactory<>("clinicName"));
        colReason.setCellValueFactory(new PropertyValueFactory<>("reason"));
        colIllness.setCellValueFactory(new PropertyValueFactory<>("illness"));
        colReports.setCellValueFactory(new PropertyValueFactory<>("reports"));
        colMedicine.setCellValueFactory(new PropertyValueFactory<>("medicine"));
        colDoctorID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
    }

    public void SearchPatientHistory(ActionEvent actionEvent) {
        try {
            ObservableList<ManagemntPatientDetailsTm> list = new ClinicManagementController().getPatientDetails(txtPatientHistoryID.getText());
            ObservableList<ManagemntPatientHistoryTm> historyTms = new ClinicManagementController().getPatientHistory(txtPatientHistoryID.getText());
            lblPatientDetails.setItems(list);
            tblHistory.setItems(historyTms);




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
