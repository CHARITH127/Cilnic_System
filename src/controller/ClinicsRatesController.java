package controller;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import model.ChartModel;

import java.util.ArrayList;
import java.util.List;

public class ClinicsRatesController {
    public BarChart clinicRates;
    public CategoryAxis x;
    public NumberAxis y;

    public void initialize(){

        XYChart.Series series = new XYChart.Series();
        List<ChartModel> list = new ArrayList<>();

        list = new ClinicRatesController().getClinicRates();

        for (ChartModel chartModel : list) {

            series.getData().add(new XYChart.Data<>(chartModel.getName(),chartModel.getValue()));
        }

        clinicRates.getData().addAll(series);

    }

}
