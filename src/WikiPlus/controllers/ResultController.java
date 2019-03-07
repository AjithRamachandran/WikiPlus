package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;

import static utils.common.openLink;


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

    @FXML
    private void resultList() throws IOException {
        Main.showScene("fxml/ResultList.fxml");
    }

    @FXML
    private void home() throws IOException {
        Main.showScene("fxml/Search.fxml");
    }

    @FXML
    public void Telegram() {
        openLink("https://t.me/MightyOdinSon");
    }

    @FXML
    public void Github() {
        openLink("https://github.com/AjithRamachandran/WikiPlus");
    }

    @FXML
    public void Instagram() {
        openLink("https://www.instagram.com");
    }
}
