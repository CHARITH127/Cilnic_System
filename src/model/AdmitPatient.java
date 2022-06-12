package model;

public class AdmitPatient {

    private String patientID;
    private String patientName;
    private int patientAge;
    private String reason;
    private String illnes;
    private String reports;
    private String medicine;
    private int Wordnum;
    private int bedNUm;

    public AdmitPatient() {
    }

    public AdmitPatient(String patientID, String patientName, int patientAge, String reason, String illnes, String reports, String medicine, int wordnum, int bedNUm) {
        this.patientID = patientID;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.reason = reason;
        this.illnes = illnes;
        this.reports = reports;
        this.medicine = medicine;
        Wordnum = wordnum;
        this.bedNUm = bedNUm;
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

    public String getIllnes() {
        return illnes;
    }

    public void setIllnes(String illnes) {
        this.illnes = illnes;
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

    public int getWordnum() {
        return Wordnum;
    }

    public void setWordnum(int wordnum) {
        Wordnum = wordnum;
    }

    public int getBedNUm() {
        return bedNUm;
    }

    public void setBedNUm(int bedNUm) {
        this.bedNUm = bedNUm;
    }
}
