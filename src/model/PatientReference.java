package model;

public class PatientReference {
    private String patientID;
    private String patientName;
    private int patientAge;
    private String StewName;
    private int stewTel;

    public PatientReference() {
    }

    public PatientReference(String patientID, String patientName, int patientAge, String stewName, int stewTel) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientAge = patientAge;
        StewName = stewName;
        this.stewTel = stewTel;
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

    public String getStewName() {
        return StewName;
    }

    public void setStewName(String stewName) {
        StewName = stewName;
    }

    public int getStewTel() {
        return stewTel;
    }

    public void setStewTel(int stewTel) {
        this.stewTel = stewTel;
    }
}
