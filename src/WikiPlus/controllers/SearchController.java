package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;


import java.io.IOException;

import static utils.common.isInternetAvailable;
import static utils.common.openLink;

public class SearchController {

    @FXML private TextField searchField;

    @FXML
    public void search() throws IOException {

        Main.showScene("fxml/LoadingPage.fxml");

        Task<Parent> task = new Task<Parent>() {
            @Override
            public Parent call() throws Exception {
                String Text = searchField.getText();
                ResultListController.setSearchText(Text);
                if (isInternetAvailable()) {
                    return FXMLLoader.load(Main.class.getResource("fxml/ConnectionFail.fxml"));
                } else {
                    return FXMLLoader.load(Main.class.getResource("fxml/ResultList.fxml"));
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
