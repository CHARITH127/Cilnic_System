package view.tm;

import java.util.Date;

public class ManagemntPatientHistoryTm {

    private Date clincDate;
    private String clinicName;
    private String reason;
    private String illness;
    private String reports;
    private String medicine;
    private String doctorID;

    public ManagemntPatientHistoryTm() {
    }

    public ManagemntPatientHistoryTm(Date clincDate, String clinicName, String reason, String illness, String reports, String medicine, String doctorID) {
        this.clincDate = clincDate;
        this.clinicName = clinicName;
        this.reason = reason;
        this.illness = illness;
        this.reports = reports;
        this.medicine = medicine;
        this.doctorID = doctorID;
    }

    public Date getClincDate() {
        return clincDate;
    }

    public void setClincDate(Date clincDate) {
        this.clincDate = clincDate;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
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
}
