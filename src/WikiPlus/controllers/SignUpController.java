package WikiPlus.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import WikiPlus.Main;
import utils.database;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController {
    @FXML private TextField firstName, lastName, userName, passWord;

    @FXML
    private void home() throws IOException {
        Main.showScene("fxml/Search.fxml");
    }

    @FXML
    private void signUp() throws SQLException {
        String fName = firstName.getText();
        String lName = lastName.getText();
        String uName = userName.getText();
        String pWord = passWord.getText();
        database db = new database();
        int result = db.signUp(fName, lName, uName, pWord);
        if(result != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Username Already Exists!");
            alert.showAndWait();
        } else {
            Main.isSignedIn = true;
            SearchController.setMenuItems(uName);
            ResultController.setMenuItems(uName);
            ResultListController.setMenuItems(uName);
        }
    }
}