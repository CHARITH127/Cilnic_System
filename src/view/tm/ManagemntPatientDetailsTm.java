package view.tm;

public class ManagemntPatientDetailsTm {

    private String patientName;
    private int patientAge;
    private String StewardName;
    private int stewTel;

    public ManagemntPatientDetailsTm() {
    }

    public ManagemntPatientDetailsTm(String patientName, int patientAge, String stewardName, int stewTel) {
        this.patientName = patientName;
        this.patientAge = patientAge;
        StewardName = stewardName;
        this.stewTel = stewTel;
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

    public String getStewardName() {
        return StewardName;
    }

    public void setStewardName(String stewardName) {
        StewardName = stewardName;
    }

    public int getStewTel() {
        return stewTel;
    }

    public void setStewTel(int stewTel) {
        this.stewTel = stewTel;
    }
}
