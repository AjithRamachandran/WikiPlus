package WikiPlus;

import javafx.fxml.FXML;

import java.io.IOException;

public class ResultController {
    @FXML
    private void home() throws IOException {
        Main.showScene("Search.fxml");
    }
}
