package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

import static utils.common.isInternetAvailable;
import static utils.common.openLink;

public class SearchController {

    @FXML private TextField searchField;

    @FXML
    private void search() throws IOException {
        String Text = searchField.getText();
        ResultListController.setSearchText(Text);
        if (isInternetAvailable()) {
            Main.showScene("fxml/connectionFail.fxml");
        } else {
            Main.showScene("fxml/ResultList.fxml");
        }
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
