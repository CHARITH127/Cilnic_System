package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Reception;

import java.sql.SQLException;

public class DeleteReceptionsController {
    public JFXTextField txtReceptionID;
    public JFXTextField txtReceptionName;
    public JFXTextField txtReceptionTel;
    public JFXTextField txtReceptionPAssword;
    public JFXButton btnDeleteDoctor;
    public JFXButton btnSearchDoctor;

    public void DeleteReceptions(ActionEvent actionEvent) {
        try {
            if (new ReceptionController().deleteReception(txtReceptionID.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION,"Delete Success").showAndWait();

            }else {
                new Alert(Alert.AlertType.ERROR,"Try again").showAndWait();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void SearchReceptions(ActionEvent actionEvent) {

        try {
            Reception reception = new ReceptionController().loadReceptionDetails(txtReceptionID.getText());
            if (reception==null) {
                new Alert(Alert.AlertType.ERROR,"Empty Set").showAndWait();
            }else {
                txtReceptionID.setText(reception.getRecceptionID());
                txtReceptionName.setText(reception.getReceptionName());
                txtReceptionTel.setText(String.valueOf(reception.getTelNumber()));
                txtReceptionPAssword.setText(reception.getPassword());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
