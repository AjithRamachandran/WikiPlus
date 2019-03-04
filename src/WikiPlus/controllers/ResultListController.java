package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static utils.common.openLink;
import static utils.wikipedia.options;
import static utils.wikipedia.search;

public class ResultListController {
    private ArrayList<String> options = new ArrayList<>();
    private static String key;

    @FXML private ListView<String> tempList;

    static void setSearchText(String text) {
        key = text;
    }

    private void getOptions() throws IOException {
        options = options(key);

        if(options.isEmpty()) {
            options.add("Not Found! The Keyword you search is not found in Wikipedia! :(");
        }
    }

    @FXML
    private void initialize() throws IOException {
        getOptions();
        for (String key : options) {
            tempList.getItems().add(key);
        }
    }

    @FXML
    private void showFullContent() throws IOException {
        String keyword = tempList.getSelectionModel().getSelectedItem().replaceAll(" ", "_");
        String result = search(keyword);
        ResultController.setResultText(result);
        Main.showScene("fxml/Result.fxml");
    }

    @FXML
    private void home() throws IOException {
        Main.showScene("fxml/Search.fxml");
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
