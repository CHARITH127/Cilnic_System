package model;

import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoadDate {

    public static void loadDate(Label lbldate) {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd-MMM-yyyy");
        lbldate.setText(f.format(date));
    }
}
