package model;

public class ChartModel {

    private String name;
    private int Value;

    public ChartModel() {
    }

    public ChartModel(String name, int value) {
        this.name = name;
        Value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }
}
