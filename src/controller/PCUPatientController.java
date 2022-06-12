package controller;

import db.DbConnection;
import model.Patient;
import model.PatientReference;
import model.PtientDetailsInSections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PCUPatientController {

    public boolean addPatient(Patient patient) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO `Pcu Counter` VALUES (?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setObject(1,patient.getpID());
        stm.setObject(2,patient.getpName());
        stm.setObject(3,patient.getpAge());
        stm.setObject(4,patient.getReason());
        stm.setObject(5,patient.getSteName());
        stm.setObject(6,patient.getSteTel());

        return stm.executeUpdate()>0;
    }

    public PtientDetailsInSections getPatient(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM `Pcu Counter` WHERE PatientID=? ");
        stm.setObject(1,id);
        ResultSet set = stm.executeQuery();
        if (set.next()){
            return new PtientDetailsInSections(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getString(4)
            );
        }else {
            return  null;
        }
    }

    public PatientReference getReferenceDetails(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM `pcu counter` WHERE PatientID=? ");
        stm.setObject(1,id);
        ResultSet set = stm.executeQuery();
        if (set.next()){
            return new PatientReference(
                    set.getString(1),
                    set.getString(2),
                    Integer.parseInt(set.getString(3)),
                    set.getString(5),
                    set.getInt(6)
            );
        }else {
            return  null;
        }
    }

}
