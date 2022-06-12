package model;

import java.util.ArrayList;
import java.util.Date;

public class ClinicPatient {

    private Date date;
    private String patientID;
    private String patientName;
    private int patientAge;
    private String reason;
    private String illness;
    private String reports;
    private String medicine;
    private String doctorID;
    private ArrayList<PatientHistory> patientHistories;

    public ClinicPatient() {
    }

    public ClinicPatient(Date date, String patientID, String patientName, int patientAge, String reason, String illness, String reports, String medicine, String doctorID, ArrayList<PatientHistory> patientHistories) {
        this.date = date;
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.reason = reason;
        this.illness = illness;
        this.reports = reports;
        this.medicine = medicine;
        this.doctorID = doctorID;
        this.patientHistories = patientHistories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public ArrayList<PatientHistory> getPatientHistories() {
        return patientHistories;
    }

    public void setPatientHistories(ArrayList<PatientHistory> patientHistories) {
        this.patientHistories = patientHistories;
    }
}
