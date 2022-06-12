package model;

public class PtientDetailsInSections {

    private String patientID;
    private String patientName;
    private int age;
    private String reason;

    public PtientDetailsInSections() {
    }

    public PtientDetailsInSections(String patientID, String patientName, int age, String reason) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.age = age;
        this.reason = reason;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
