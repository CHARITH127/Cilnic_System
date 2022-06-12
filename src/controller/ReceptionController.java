package controller;

import db.DbConnection;
import model.Reception;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceptionController {

    public boolean AddReception(Reception  reception) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("INSERT INTO receptions VALUES (?,?,?,?)");
        stm.setObject(1,reception.getRecceptionID());
        stm.setObject(2,reception.getReceptionName());
        stm.setObject(3,reception.getTelNumber());
        stm.setObject(4,reception.getPassword());

        return stm.executeUpdate()>0;
    }

    public Reception loadReceptionDetails(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM receptions WHERE ReceptionID=?");
        stm.setObject(1,id);
        ResultSet set = stm.executeQuery();
        if (set.next()){
            return  new Reception(
                    set.getNString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getString(4)
            );
        }else {
            return null;
        }
    }

    public  boolean updateReception(Reception reception) throws SQLException, ClassNotFoundException {
        PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("UPDATE receptions SET  ReceptionName=?, ReceptionTelephoneNumber=?, Password=? WHERE ReceptionID=?");
        statement.setObject(1,reception.getReceptionName());
        statement.setObject(2,reception.getTelNumber());
        statement.setObject(3,reception.getPassword());
        statement.setObject(4,reception.getRecceptionID());

        return statement.executeUpdate()>0;
    }

    public boolean deleteReception(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("DELETE FROM receptions WHERE ReceptionID=?");
        stm.setObject(1,id);
        return stm.executeUpdate()>0;
    }
}
