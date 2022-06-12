package util;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.TextInputControl;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class Validations {

    public static Object validate(LinkedHashMap<TextInputControl, Pattern> map , JFXButton btn){
        btn.setDisable(true);
        for (TextInputControl textFieldKey : map.keySet()) {
            Pattern patternValue = map.get(textFieldKey);
            if (!patternValue.matcher(textFieldKey.getText()).matches()) {
                if (!textFieldKey.getText().isEmpty()) {
                    textFieldKey.setStyle("-fx-border-color: red");
                    textFieldKey.setStyle("-fx-text-fill: red");
                }
                return textFieldKey;
            }
            textFieldKey.setStyle("-fx-border-color: green");
            textFieldKey.setStyle("-fx-text-fill: blue");
        }
        btn.setDisable(false);
        return true;
    }
}
