package view.tm;

import java.util.Date;

public class PatienHistoryTm {

    private Date date;
    private String reports;
    private String medcine;
    private String doctorID;

    public PatienHistoryTm() {
    }

    public PatienHistoryTm(Date date, String reports, String medcine, String doctorID) {
        this.date = date;
        this.reports = reports;
        this.medcine = medcine;
        this.doctorID = doctorID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public String getMedcine() {
        return medcine;
    }

    public void setMedcine(String medcine) {
        this.medcine = medcine;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }
}
