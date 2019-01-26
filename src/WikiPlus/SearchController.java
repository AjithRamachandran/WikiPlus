package WikiPlus;

import javafx.fxml.FXML;

import java.io.IOException;

public class SearchController {

    @FXML
    private void search() throws IOException {
        Main.showScene("Result.fxml");
    }

    @FXML
    private void signIn() throws IOException {
        Main.showScene("SignIn.fxml");
    }

    @FXML
    private void signUp() throws IOException {
        Main.showScene("SignUp.fxml");
    }

}
