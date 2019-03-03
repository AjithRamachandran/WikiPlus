package WikiPlus.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class ResultController {
    private static String resultText;

    @FXML private TextArea content;

    static void setResultText(String text) {
        resultText = text;
    }

    @FXML
    private void initialize() {
        content.setText(resultText);
    }

    public static void setMenuItems(String uName) {
    }

}
