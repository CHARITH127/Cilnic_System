package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Reception;

import java.security.acl.AclNotFoundException;
import java.sql.SQLException;

public class UpdateReceptionsController {

    public JFXTextField txtReceptionID;
    public JFXTextField txtReceptionName;
    public JFXTextField txtReceptionTel;
    public JFXTextField txtReceptionPAssword;
    public JFXButton btnUpdateReception;
    public JFXButton btnSearchReception;

    public void UpdateReception(ActionEvent actionEvent) {
        Reception reception = new Reception(
                txtReceptionID.getText(),
                txtReceptionName.getText(),
                Integer.parseInt(txtReceptionTel.getText()),
                txtReceptionPAssword.getText()
        );

        try {
            if (new ReceptionController().updateReception(reception)) {
                new Alert(Alert.AlertType.CONFIRMATION,"Updating Successful").showAndWait();
                clearAll();
            }else {
                new Alert(Alert.AlertType.ERROR,"Try again").showAndWait();
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void SearchReception(ActionEvent actionEvent) {

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

    private void clearAll() {
        txtReceptionID.clear();
        txtReceptionName.clear();
        txtReceptionTel.clear();
        txtReceptionPAssword.clear();
    }
}
