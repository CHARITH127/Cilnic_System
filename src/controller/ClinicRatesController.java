package controller;

import db.DbConnection;
import model.ChartModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClinicRatesController {

    public int getEyeClinicRate(){
        try {
            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `eye clinc`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getEntClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `ent clinc`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getSurgicalClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `surgery clinc`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getMedicalClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `medical clinc`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getStdClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `std clinc`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getWellBabyClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `well baby clinc`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getPeadiatricClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `paediatrics clinc`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getGynObsClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `gyn & obs`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getFamilyMedicalClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `family medical`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getCanserClinicRate(){
        try {

            PreparedStatement stm = DbConnection.getInstance().getConnection().prepareStatement("select count(*) from `cancer clinc`");
            ResultSet set = stm.executeQuery();
            set.next();
            int Count = set.getInt(1);
            System.out.println(Count);
            return Count;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<ChartModel> getClinicRates(){
        ArrayList<ChartModel> models = new ArrayList<>();
        models.add(new ChartModel("Eye Clinic",getEyeClinicRate()));
        models.add(new ChartModel("ENT Clinic",getEntClinicRate()));
        models.add(new ChartModel("Surgical Clinic",getSurgicalClinicRate()));
        models.add(new ChartModel("Medical Clinic",getMedicalClinicRate()));
        models.add(new ChartModel("STD Clinic",getStdClinicRate()));
        models.add(new ChartModel("Well Baby Clinic",getWellBabyClinicRate()));
        models.add(new ChartModel("Peadiatric Clinic",getPeadiatricClinicRate()));
        models.add(new ChartModel("GYN & OBS Clinic",getGynObsClinicRate()));
        models.add(new ChartModel("Family Medical Clinic",getFamilyMedicalClinicRate()));
        models.add(new ChartModel("Cancer Clinic",getCanserClinicRate()));

        return models;
    }

}
