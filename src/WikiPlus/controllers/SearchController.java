package WikiPlus.controllers;

import WikiPlus.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


import java.io.IOException;

public class SearchController {

    @FXML private TextField searchField;
    @FXML private static Menu options;

    static void setMenuItems(String userName) {
        options.getItems().clear();
        options.getItems().add(new MenuItem(userName));
    }

    @FXML
    private void search() throws IOException {
        String Text = searchField.getText();
        ResultListController.setSearchText(Text);
        Main.showScene("fxml/ResultList.fxml");
    }

    @FXML
    private void signIn() throws IOException {
        Main.showScene("fxml/SignIn.fxml");
    }

    @FXML
    private void signUp() throws IOException {
        Main.showScene("fxml/SignUp.fxml");
    }

}
