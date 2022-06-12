package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Doctor;
import view.tm.ManagemntPatientDetailsTm;
import view.tm.ManagemntPatientHistoryTm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClinicManagementController {

    public ObservableList<ManagemntPatientDetailsTm> getPatientDetails(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM  `patient referal` WHERE PatientID=?");
        stm.setObject(1,id);
        ResultSet set = stm.executeQuery();
        ObservableList<ManagemntPatientDetailsTm> list = FXCollections.observableArrayList();
        while (set.next()){
            list.add(
                    new ManagemntPatientDetailsTm(
                            set.getString(2),
                            set.getInt(3),
                            set.getString(4),
                            set.getInt(5)
                    )
            );
        }

        return list;
    }

    public ObservableList<ManagemntPatientHistoryTm> getPatientHistory(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM `patient history` WHERE PatientID=?");
        stm.setObject(1,id);
        ResultSet set = stm.executeQuery();

        ObservableList<ManagemntPatientHistoryTm> history = FXCollections.observableArrayList();

        while (set.next()){
            history.add(new ManagemntPatientHistoryTm(
                    set.getDate(1),
                    set.getString(2),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8),
                    set.getString(9),
                    set.getString(10)
            ));
        }


        return history;
    }


    public ObservableList<Doctor> getDoctorDetails() throws SQLException, ClassNotFoundException {

        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM doctor");
        ResultSet set = stm.executeQuery();
        ObservableList<Doctor> list = FXCollections.observableArrayList();
        while (set.next()){
            list.add(new Doctor(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getString(4),
                    set.getString(5)
            ));
        }

        return list;

    }

}
