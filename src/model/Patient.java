package model;

public class Patient {

    private String pID;
    private String pName;
    private int pAge;
    private String reason;
    private String steName;
    private int steTel;

    public Patient() {
    }

    public Patient(String pID, String pName, int pAge, String reason, String steName, int steTel) {
        this.pID = pID;
        this.pName = pName;
        this.pAge = pAge;
        this.reason = reason;
        this.steName = steName;
        this.steTel = steTel;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSteName() {
        return steName;
    }

    public void setSteName(String steName) {
        this.steName = steName;
    }

    public int getSteTel() {
        return steTel;
    }

    public void setSteTel(int steTel) {
        this.steTel = steTel;
    }
}
