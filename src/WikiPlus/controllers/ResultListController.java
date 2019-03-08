package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;

import static utils.common.isInternetAvailable;
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

        Main.showScene("fxml/LoadingPage.fxml");

        Task<Parent> task = new Task<Parent>() {
            @Override
            public Parent call() throws Exception {
                String keyword = tempList.getSelectionModel().getSelectedItem().replaceAll(" ", "_");
                String result = search(keyword);
                ResultController.setResultText(result);
                if (isInternetAvailable()) {
                    return FXMLLoader.load(Main.class.getResource("fxml/ConnectionFail.fxml"));
                } else {
                    return FXMLLoader.load(Main.class.getResource("fxml/Result.fxml"));
                }
            }
        };

        task.setOnSucceeded(e -> {
            Main.window.setScene(new Scene(task.getValue()));
            Main.window.setResizable(false);
            Main.window.setOnCloseRequest(f -> Platform.exit());
            Main.window.show();
        });

        Thread thread = new Thread(task);
        thread.start();
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
