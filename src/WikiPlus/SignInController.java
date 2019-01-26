package WikiPlus;

import javafx.fxml.FXML;

import java.io.IOException;

public class SignInController {
    @FXML
    private void signUp() throws IOException {
        Main.showScene("SignUp.fxml");
    }

    @FXML
    private void home() throws IOException {
        Main.showScene("Search.fxml");
    }
}
