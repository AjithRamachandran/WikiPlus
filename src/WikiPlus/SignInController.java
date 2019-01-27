package WikiPlus;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
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
        boolean result = (uName.length() > pWord.length());
//        metacall_load_from_file('py', [ 'db.cpp' ]);
//        boolean result = metacall('search', );
        if(result) {
            Main.isSignedIn = true;
            SearchController.setMenuItems(uName);
            ResultController.setMenuItems(uName);
            ResultListController.setMenuItems(uName);
        }
    }
}
