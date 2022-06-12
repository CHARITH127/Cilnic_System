package controller;

import db.DbConnection;
import model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorController {

    public boolean AddDoctors(Doctor doctor) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getInstance().getConnection();
        String query = "INSERT INTO doctor VALUES(?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(query);
        stm.setObject(1,doctor.getDoctorID());
        stm.setObject(2,doctor.getDoctorName());
        stm.setObject(3,doctor.getTelephoneNumber());
        stm.setObject(4,doctor.getSpecializeArea());
        stm.setObject(5,doctor.getPassword());

        return stm.executeUpdate()>0;
    }

    public Doctor getDoctor(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT * FROM Doctor WHERE DoctorID =?");
        statement.setObject(1,id);
        ResultSet set = statement.executeQuery();
        if (set.next()){
            return new Doctor(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getString(4),
                    set.getString(5)
            );
        }else{
            return null;
        }

    }

    public  boolean UpdateDoctor(Doctor doctor) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("UPDATE doctor SET DoctorName=?, DoctorTelephoneNumber=?," +
                "SpecializeArea=?,Password=? WHERE DoctorID=?");
        statement.setObject(1,doctor.getDoctorName());
        statement.setObject(2,doctor.getTelephoneNumber());
        statement.setObject(3,doctor.getSpecializeArea());
        statement.setObject(4,doctor.getPassword());
        statement.setObject(5,doctor.getDoctorID());

        return statement.executeUpdate()>0;
    }

    public boolean deleteDoctor(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM doctor WHERE DoctorID=? ");
        statement.setObject(1,id);
        if (statement.executeUpdate()>0) {
            return true;
        }else {
            return false;
        }
    }
}
