package controller;

import db.DbConnection;
import model.PatientReference;
import model.SearchPatien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientTransferAdmitPCU {

    public boolean addPatientToSearchAdmissionRoom(SearchPatien patien)  {

        Connection con = null;
        try {
            con = DbConnection.getInstance().getConnection();
            PreparedStatement stm = con.prepareStatement("INSERT INTO `search admission room` VALUES (?,?,?,?,?,?,?)");
            stm.setObject(1,patien.getPatienID());
            stm.setObject(2,patien.getPatientName());
            stm.setObject(3,patien.getPatientAge());
            stm.setObject(4,patien.getReason());
            stm.setObject(5,patien.getIllness());
            stm.setObject(6,patien.getReports());
            stm.setObject(7,patien.getMedicine());


            if (stm.executeUpdate()>0) {
                if (upDatePatientRefernece(new PCUPatientController().getReferenceDetails(patien.getPatienID()))) {
                    if (deletepatientOnPCU(patien.getPatienID())) {
                        return true;
                    }else {
                        return false;
                    }
                }else {
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean upDatePatientRefernece(PatientReference referenceDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Patient Referal` VALUES (?,?,?,?,?)");
        stm.setObject(1,referenceDetails.getPatientID());
        stm.setObject(2,referenceDetails.getPatientName());
        stm.setObject(3,referenceDetails.getPatientAge());
        stm.setObject(4,referenceDetails.getStewName());
        stm.setObject(5,referenceDetails.getStewTel());

        return stm.executeUpdate()>0;
    }

    public boolean deletepatientOnPCU(String patienID) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM `pcu counter` WHERE PatientID=?");
        stm.setObject(1,patienID);
        return stm.executeUpdate()>0;
    }

}
