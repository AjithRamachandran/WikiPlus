package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.fxml.FXML;


import java.io.IOException;

import static utils.common.ResultList;


public class ConnectionFailController {

    @FXML
    public void refresh() throws IOException {
        ResultList();
    }

    @FXML
    private void home() throws IOException {
        Main.showScene("fxml/Search.fxml");
    }
}
