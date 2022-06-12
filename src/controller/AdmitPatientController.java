package controller;

import db.DbConnection;
import model.AdmitPatient;
import model.PatientReference;
import model.SearchPatien;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdmitPatientController {

    public boolean admitPatient(AdmitPatient patient) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO `Admission room` VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setObject(1,patient.getPatientID());
        stm.setObject(2,patient.getPatientName());
        stm.setObject(3,patient.getPatientAge());
        stm.setObject(4,patient.getReason());
        stm.setObject(5,patient.getIllnes());
        stm.setObject(6,patient.getReports());
        stm.setObject(7,patient.getMedicine());
        stm.setObject(8,patient.getWordnum());
        stm.setObject(9,patient.getBedNUm());

       return stm.executeUpdate()>0;
    }

    public boolean addPatientReference(PatientReference reference) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `patient referal` VALUES (?,?,?,?,?)");
        stm.setObject(1,reference.getPatientID());
        stm.setObject(2,reference.getPatientName());
        stm.setObject(3,reference.getPatientAge());
        stm.setObject(4,reference.getStewName());
        stm.setObject(5,reference.getStewTel());

       return stm.executeUpdate()>0;
    }

    public  AdmitPatient getPatientDetails(String ID) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT  * FROM `Admission room` WHERE PatientID=? ");
        stm.setObject(1,ID);
        ResultSet set = stm.executeQuery();
        if (set.next()){
            return new AdmitPatient(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getInt(8),
                    set.getInt(9)
            );
        }else {
            return null;
        }
    }

    public boolean updatePatient(AdmitPatient patient) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm= connection.prepareStatement("UPDATE `Admission room` SET PatientName=?,PatientAge=?,Reson=?,Illness=?,Reports=?,Medicine=?,WordNumber=?,BedNumber=? WHERE PatientID=?");
       stm.setObject(1,patient.getPatientName());
       stm.setObject(2,patient.getPatientAge());
       stm.setObject(3,patient.getReason());
       stm.setObject(4,patient.getIllnes());
       stm.setObject(5,patient.getReports());
       stm.setObject(6,patient.getMedicine());
       stm.setObject(7,patient.getWordnum());
       stm.setObject(8,patient.getBedNUm());
       stm.setObject(9,patient.getPatientID());

        return stm.executeUpdate()>0;
    }

    public  boolean deletePatientofAdmitionRoom(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM `Admission room` WHERE PatientID=?");
        statement.setObject(1,id);
        return  statement.executeUpdate()>0;
    }

    public  boolean deletePatientofReferal(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM `patient referal` WHERE PatientID=?");
        statement.setObject(1,id);
        return  statement.executeUpdate()>0;
    }

    public SearchPatien loadPationOnSearchAdmission(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM  `search admission room` WHERE PatientID=?");
        stm.setObject(1,id);
        ResultSet set = stm.executeQuery();
        if (set.next()){
            return new SearchPatien(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getString(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7)

            );
        }else {
            return null;
        }
    }

    public PatientReference getPationReferel(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM `patient referal` WHERE PatientID=?");
        stm.setObject(1,id);
        ResultSet set = stm.executeQuery();
        if (set.next()) {
            return new PatientReference(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getString(4),
                    set.getInt(5)
            );
        }else {
            return null;
        }
    }

    public boolean deleteSearchAdmition(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM `search admission room` WHERE PatientID=?");
        stm.setObject(1,id);
        return stm.executeUpdate()>0;
    }

    public boolean delePatientOnHistory(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM `patient history` WHERE PatientID=? ");
        stm.setObject(1,id);
        if (stm.executeUpdate()>0){
            return true;
        }
        return false;
    }
}
