package model;

public class SearchPatien {

    private String patienID;
    private String patientName;
    private int patientAge;
    private String reason;
    private String illness;
    private String reports;
    private String medicine;

    public SearchPatien() {
    }

    public SearchPatien(String patienID, String patientName, int patientAge, String reason, String illness, String reports, String medicine) {
        this.patienID = patienID;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.reason = reason;
        this.illness = illness;
        this.reports = reports;
        this.medicine = medicine;
    }

    public String getPatienID() {
        return patienID;
    }

    public void setPatienID(String patienID) {
        this.patienID = patienID;
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
}
