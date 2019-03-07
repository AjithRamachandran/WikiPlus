package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.fxml.FXML;

import java.io.IOException;

import static utils.common.isInternetAvailable;

public class ConnectionFailController {

    @FXML
    public void refresh() throws IOException {
        if (isInternetAvailable()) {
            Main.showScene("fxml/connectionFail.fxml");
        } else {
            Main.showScene("fxml/ResultList.fxml");
        }
    }

    @FXML
    private void home() throws IOException {
        Main.showScene("fxml/Search.fxml");
    }
}
