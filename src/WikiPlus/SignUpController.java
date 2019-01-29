package WikiPlus;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController {
    @FXML private TextField firstName, lastName, userName, passWord;

    @FXML
    private void home() throws IOException {
        Main.showScene("Search.fxml");
    }

    @FXML
    private void signUp() {
        String fName = firstName.getText();
        String lName = lastName.getText();
        String uName = userName.getText();
        String pWord = passWord.getText();
        database db = new database();
        int result = db.createUser(fName, lName, uName, pWord);
    }
}
