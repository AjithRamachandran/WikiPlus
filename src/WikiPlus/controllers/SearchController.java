package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URISyntaxException;

import static utils.common.openLink;

public class SearchController {

    @FXML private TextField searchField;

    @FXML
    private void search() throws IOException {
        String Text = searchField.getText();
        ResultListController.setSearchText(Text);
        Main.showScene("fxml/ResultList.fxml");
    }

    @FXML
    public void Telegram() throws IOException, URISyntaxException {
        openLink("https://t.me/MightyOdinSon");
    }

    @FXML
    public void Github() throws IOException, URISyntaxException {
        openLink("https://github.com/AjithRamachandran/WikiPlus");
    }

    @FXML
    public void Instagram() throws IOException, URISyntaxException {
        openLink("https://www.instagram.com");
    }

}
