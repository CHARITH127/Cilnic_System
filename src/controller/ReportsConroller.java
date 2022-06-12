package controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class ReportsConroller {

    public void showUpdateReport(String ClinicName, String patientID, String patientName, String patientAge, String reason, String illness, String reports, String medicine , String doctorID , String date){
        try {
            JasperDesign desing = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/Reports/EyeClinicResit.jrxml"));
            JasperReport compileReport = JasperCompileManager.compileReport(desing);

            String clinicName=ClinicName;
            String tempPatietID = patientID;
            String tempPatientName = patientName;
            String tempPatientAge = patientAge;
            String tempReson = reason;
            String tempIllness = illness;
            String tempReports = reports;
            String tempMedicine = medicine;
            String tempDoctorID = doctorID;
            String tempdate = date;

            HashMap map = new HashMap();
            map.put("clincName",clinicName);
            map.put("PatientID",tempPatietID);
            map.put("patientName",tempPatientName);
            map.put("patientAge",tempPatientAge);
            map.put("patientReason",tempReson);
            map.put("patientIllness",tempIllness);
            map.put("patientReports",tempReports);
            map.put("patientMedicine",tempMedicine);
            map.put("doctorID",tempDoctorID);
            map.put("nextClinicDate ",tempdate);

            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, new JREmptyDataSource(1));
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    public void showAdmitRport( String patientID, String patientName, String patientAge, String reason, String illness, String reports, String medicine , String doctorID , String date){
        try {
            JasperDesign design = JRXmlLoader.load(this.getClass().getResourceAsStream("/view/Reports/AdmitResit.jrxml"));
            JasperReport compileReport = JasperCompileManager.compileReport(design);

            String tempPatietID = patientID;
            String tempPatientName = patientName;
            String tempPatientAge = patientAge;
            String tempReson = reason;
            String tempIllness = illness;
            String tempReports = reports;
            String tempMedicine = medicine;
            String tempDoctorID = doctorID;
            String tempdate = date;

            HashMap map = new HashMap();
            map.put("patientID",tempPatietID);
            map.put("patientName",tempPatientName);
            map.put("patientAge",tempPatientAge);
            map.put("Reason",tempReson);
            map.put("illness",tempIllness);
            map.put("reports",tempReports);
            map.put("medicine",tempMedicine);
            map.put("doctorID",tempDoctorID);
            map.put("date ",tempdate);

            JasperPrint jasperPrint = JasperFillManager.fillReport(compileReport, map, new JREmptyDataSource(1));
            JasperViewer.viewReport(jasperPrint,false);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
