package model;

public class Reception {

    private String recceptionID;
    private String receptionName;
    private int telNumber;
    private String password;

    public Reception() {
    }



    public Reception(String recceptionID, String receptionName, int telNumber, String password) {
        this.recceptionID = recceptionID;
        this.receptionName = receptionName;
        this.telNumber = telNumber;
        this.password = password;
    }

    public String getRecceptionID() {
        return recceptionID;
    }

    public void setRecceptionID(String recceptionID) {
        this.recceptionID = recceptionID;
    }

    public String getReceptionName() {
        return receptionName;
    }

    public void setReceptionName(String receptionName) {
        this.receptionName = receptionName;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(int telNumber) {
        this.telNumber = telNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
