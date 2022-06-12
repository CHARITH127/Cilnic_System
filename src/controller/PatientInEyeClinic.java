package controller;

import db.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ClinicPatient;
import model.PatientHistory;
import model.PatientReference;
import model.SearchPatien;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.omg.CORBA.CODESET_INCOMPATIBLE;
import view.tm.PatienHistoryTm;

import java.awt.dnd.DnDConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientInEyeClinic {

    public boolean addPatientDirectly(ClinicPatient patient){
        Connection connection =null;
        try {
             connection = DbConnection.getInstance().getConnection();
             connection.setAutoCommit(false);
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO  `eye clinc` VALUES (?,?,?,?,?,?,?,?,?)");
            stm.setObject(1,patient.getDate());
            stm.setObject(2,patient.getPatientID());
            stm.setObject(3,patient.getPatientName());
            stm.setObject(4,patient.getPatientAge());
            stm.setObject(5,patient.getReason());
            stm.setObject(6,patient.getIllness());
            stm.setObject(7,patient.getReports());
            stm.setObject(8,patient.getMedicine());
            stm.setObject(9,patient.getDoctorID());

           if (stm.executeUpdate()>0){
               if (UpdatePatientHistory(patient.getPatientHistories())) {
                   connection.commit();
                   return true;
               }else{
                  connection.rollback();
                   return false;
               }
           }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }


    public  boolean addPatientInToTheClinic(ClinicPatient patient){
        try {
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO  `eye clinc` VALUES (?,?,?,?,?,?,?,?,?)");
            stm.setObject(1,patient.getDate());
            stm.setObject(2,patient.getPatientID());
            stm.setObject(3,patient.getPatientName());
            stm.setObject(4,patient.getPatientAge());
            stm.setObject(5,patient.getReason());
            stm.setObject(6,patient.getIllness());
            stm.setObject(7,patient.getReports());
            stm.setObject(8,patient.getMedicine());
            stm.setObject(9,patient.getDoctorID());

            if (stm.executeUpdate()>0) {
                if (savePatientHistory(patient.getPatientHistories())){
                    return true;
                }else {
                    return false;
                }

            }else {
                return false;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    private boolean savePatientHistory(ArrayList<PatientHistory> patientHistories) throws SQLException, ClassNotFoundException {
        for (PatientHistory patientHistory : patientHistories) {
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO `patient history` VALUES (?,?,?,?,?,?,?,?,?,?)");
            stm.setObject(1,patientHistory.getDate());
            stm.setObject(2,patientHistory.getClinicName());
            stm.setObject(3,patientHistory.getPatientID());
            stm.setObject(4,patientHistory.getPatientName());
            stm.setObject(5,patientHistory.getPatientAge());
            stm.setObject(6,patientHistory.getReason());
            stm.setObject(7,patientHistory.getIllness());
            stm.setObject(8,patientHistory.getReports());
            stm.setObject(9,patientHistory.getMedicine());
            stm.setObject(10,patientHistory.getDoctorID());

            if (stm.executeUpdate()>0) {
                    if (deleteDetailsOnSection(patientHistory.getSection(),patientHistory.getPatientID())){
                        return true;
                    }else{
                        return false;
                    }
            }else {
                return false;
            }
        }

        return false;
    }

    private boolean deleteDetailsOnSection(String section,String id) throws SQLException, ClassNotFoundException {
        if (section.equalsIgnoreCase("opd")){
            PatientReference referenceDetails = new OPDPatientController().getReferenceDetails(id);
            if (upDatePatientRefernece(referenceDetails)){
                if (deleteOnOPd(id)) {
                    return true;
                }else {
                    return false;
                }
            }
        }else if (section.equalsIgnoreCase("pcu")){
            PatientReference referenceDetails = new PCUPatientController().getReferenceDetails(id);
            if (upDatePatientRefernece(referenceDetails)){
                if (deleteOnPCU(id)){
                    return true;
                }else {
                    return false;
                }
            }

        }else if(section.equalsIgnoreCase("admission room")){
            if (deleteOnAdmissionRoom(id)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    private boolean deleteOnAdmissionRoom(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM `admission room` WHERE PatientID=?");
        stm.setObject(1,id);
        if (stm.executeUpdate()>0) {
            return true;
        }else {
            return false;
        }
    }

    private boolean deleteOnPCU(String id) throws SQLException, ClassNotFoundException {

        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM `pcu counter` WHERE PatientID=?");
        stm.setObject(1,id);
        if (stm.executeUpdate()>0) {
            return true;
        }else {
            return false;
        }

    }

    private boolean deleteOnOPd(String id) throws SQLException, ClassNotFoundException {

        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM `opd counter` WHERE PatientID=?");
        stm.setObject(1,id);
        if (stm.executeUpdate()>0) {
            return true;
        }else {
            return false;
        }

    }

    public boolean upDatePatientRefernece(PatientReference referenceDetails) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Patient Referal` VALUES (?,?,?,?,?)");
        stm.setObject(1,referenceDetails.getPatientID());
        stm.setObject(2,referenceDetails.getPatientName());
        stm.setObject(3,referenceDetails.getPatientAge());
        stm.setObject(4,referenceDetails.getStewName());
        stm.setObject(5,referenceDetails.getStewTel());

        return stm.executeUpdate()>0;
    }

    public SearchPatien getPatient(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM `eye clinc` WHERE PatientID =?");
        stm.setObject(1,id);
        ResultSet set = stm.executeQuery();
        if (set.next()) {

            return new SearchPatien(
                    set.getString(2),
                    set.getString(3),
                    set.getInt(4),
                    set.getString(5),
                    set.getString(6),
                    set.getString(7),
                    set.getString(8)
            );

        }else {
            return null;
        }

    }

    public boolean UpdatePatientHistory(ArrayList<PatientHistory> patientHistories) throws SQLException, ClassNotFoundException {
        for (PatientHistory patientHistory : patientHistories) {
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO `patient history` VALUES (?,?,?,?,?,?,?,?,?,?)");
            stm.setObject(1, patientHistory.getDate());
            stm.setObject(2, patientHistory.getClinicName());
            stm.setObject(3, patientHistory.getPatientID());
            stm.setObject(4, patientHistory.getPatientName());
            stm.setObject(5, patientHistory.getPatientAge());
            stm.setObject(6, patientHistory.getReason());
            stm.setObject(7, patientHistory.getIllness());
            stm.setObject(8, patientHistory.getReports());
            stm.setObject(9, patientHistory.getMedicine());
            stm.setObject(10, patientHistory.getDoctorID());

            return stm.executeUpdate() > 0;
        }

        return false;
    }

    public boolean deletePatientOnClinic(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM `eye clinc` WHERE PatientID =?");
        stm.setObject(1,id);
        if (stm.executeUpdate()>0) {
            if (delePatientOnHistory(id)) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean delePatientOnHistory(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM `patient history` WHERE PatientID=? ");
        stm.setObject(1,id);
        if (stm.executeUpdate()>0){
            if (deletePatientReference(id)) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean deletePatientReference(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM `patient referal` WHERE PatientID=?");
        stm.setObject(1,id);
        return stm.executeUpdate()>0;
    }

    public boolean updatePatient(ClinicPatient patient) {
        Connection connection=null;
        try {
            connection = DbConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement stm = connection.prepareStatement("UPDATE `eye clinc` SET ClinicDate=?,PatientName=?, PatientAge=?,  Reson=?, Illness=?, Reports=?, Medicine=?, DoctorID=? WHERE PatientID=?");
            stm.setObject(1,patient.getDate());
            stm.setObject(2,patient.getPatientName());
            stm.setObject(3,patient.getPatientAge());
            stm.setObject(4,patient.getReason());
            stm.setObject(5,patient.getIllness());
            stm.setObject(6,patient.getReports());
            stm.setObject(7,patient.getMedicine());
            stm.setObject(8,patient.getDoctorID());
            stm.setObject(9,patient.getPatientID());

            if (stm.executeUpdate()>0) {
                if (UpdatePatientHistory(patient.getPatientHistories())) {
                    connection.commit();
                    return true;
                }else {
                    connection.rollback();
                    return false;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    public boolean addPatientToSearchAdmission(SearchPatien patien) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO `search admission room` VALUES (?,?,?,?,?,?,?)");
        statement.setObject(1,patien.getPatienID());
        statement.setObject(2,patien.getPatientName());
        statement.setObject(3,patien.getPatientAge());
        statement.setObject(4,patien.getReason());
        statement.setObject(5,patien.getIllness());
        statement.setObject(6,patien.getReports());
        statement.setObject(7,patien.getMedicine());

        if (statement.executeUpdate()>0) {
            if (deletePatientOnlyClinic(patien.getPatienID())) {
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean deletePatientOnlyClinic(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("DELETE FROM `eye clinc` WHERE PatientID =?");
        stm.setObject(1,id);
        return stm.executeUpdate()>0;
    }

    public ObservableList<PatienHistoryTm> getPatientHistory(String id) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getInstance().getConnection();
        PreparedStatement stm = con.prepareStatement("SELECT  * FROM `patient history` WHERE PatientID=?");
        stm.setObject(1,id);

        ObservableList<PatienHistoryTm> list = FXCollections.observableArrayList();

        ResultSet set = stm.executeQuery();
        while (set.next()){
            list.add(new PatienHistoryTm(
                    set.getDate(1),
                    set.getString(8),
                    set.getString(9),
                    set.getString(10)
            ));
        }

        return list;
    }

}
