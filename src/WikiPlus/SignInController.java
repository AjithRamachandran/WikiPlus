package WikiPlus;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignInController {
    @FXML private TextField userName, passWord;

    @FXML
    private void signUp() throws IOException {
        Main.showScene("SignUp.fxml");
    }

    @FXML
    private void home() throws IOException {
        Main.showScene("Search.fxml");
    }

    @FXML
    private void signIn() {
        String uName = userName.getText();
        String pWord = passWord.getText();
        database db = new database();
        String result = db.searchUser(uName, pWord);
        if(result.equals("Error")) {
            Main.isSignedIn = true;
            SearchController.setMenuItems(uName);
            ResultController.setMenuItems(uName);
            ResultListController.setMenuItems(uName);
        }
    }
}
