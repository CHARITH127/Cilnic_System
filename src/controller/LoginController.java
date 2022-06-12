package controller;

import db.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    public String loginControllerForDoctors(String id ){
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM  doctor WHERE DoctorID=? ");
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                return set.getString(5);
            }else {
                return null;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String loginControllerForReceptions(String id ){
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM  receptions WHERE ReceptionID=? ");
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                return set.getString(4);
            }else {
                return null;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String loginControllerForManagemnt(String id ){
        try {
            PreparedStatement statement = DbConnection.getInstance().getConnection().prepareStatement("SELECT  * FROM  Management WHERE ManagerID=? ");
            statement.setObject(1,id);
            ResultSet set = statement.executeQuery();
            if (set.next()){
                return set.getString(4);
            }else {
                return null;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
