package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Doctor;
import sun.dc.pr.PRError;

import java.sql.SQLException;

public class DoctorDetailsController {
    public TextField txtSpecializeArea;
    public TableView tblDoctors;
    public TableColumn colDoctorID;
    public TableColumn colDoctorName;
    public TableColumn colDoctorSpecializeArea;
    public TableColumn colDoctorTEl;
    public TableColumn colDoctorPassword;
    public ObservableList<Doctor> doctorDetails = FXCollections.observableArrayList();

    public void initialize(){

        colDoctorID.setCellValueFactory(new PropertyValueFactory<>("doctorID"));
        colDoctorName.setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        colDoctorTEl.setCellValueFactory(new PropertyValueFactory<>("telephoneNumber"));
        colDoctorSpecializeArea.setCellValueFactory(new PropertyValueFactory<>("specializeArea"));
        colDoctorPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

        loadDoctors();


        FilteredList<Doctor> filteddoctors = new FilteredList<>(doctorDetails,doctor -> true);

        txtSpecializeArea.textProperty().addListener((observable, oldValue, newValue) -> {
            filteddoctors.setPredicate(doctor -> {
                if (newValue ==null || newValue.isEmpty()){
                    return true;
                }

                String text = newValue.toLowerCase();

                if (doctor.getDoctorID().toLowerCase().indexOf(text)!=-1){
                    return true;
                }else if (doctor.getDoctorName().toLowerCase().indexOf(text)!=-1){
                    return true;
                }else if (doctor.getSpecializeArea().toLowerCase().indexOf(text)!=-1) {
                    return true;
                }else if (doctor.getDoctorName().toLowerCase().indexOf(text)!=-1){
                    return true;
                }else {
                    return false;/*dosn't match*/
                }

            });

        });

        SortedList<Doctor> sortedList = new SortedList<>(filteddoctors);

        sortedList.comparatorProperty().bind(tblDoctors.comparatorProperty());

        tblDoctors.setItems(sortedList);


    }

    private void loadDoctors() {

        try {
             doctorDetails =
                    new ClinicManagementController().getDoctorDetails();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
