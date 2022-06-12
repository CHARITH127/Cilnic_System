package model;

public class Doctor {

    private String doctorID;
    private String doctorName;
    private int telephoneNumber;
    private String specializeArea;
    private String password;

    public Doctor() {
    }

    public Doctor(String doctorID, String doctorName, int telephoneNumber, String specializeArea, String password) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.telephoneNumber = telephoneNumber;
        this.specializeArea = specializeArea;
        this.password = password;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getSpecializeArea() {
        return specializeArea;
    }

    public void setSpecializeArea(String specializeArea) {
        this.specializeArea = specializeArea;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
