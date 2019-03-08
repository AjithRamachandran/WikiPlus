package WikiPlus;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

import static utils.common.openLink;


public class Main extends Application {
    public static Stage window;

    @Override
    public void start(Stage window) throws Exception{
        Main.window = window;
        Parent search = FXMLLoader.load(getClass().getResource("fxml/Search.fxml"));
        window.setTitle("WikiPlus");
        window.setScene(new Scene(search));
        window.setResizable(false);
        window.setMinWidth(1000);
        window.setMinHeight(600);
        window.setOnCloseRequest(e -> Platform.exit());
        window.show();
    }

    public static void showScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource(fxml));
        Main.window.setScene(new Scene(root));
        Main.window.setResizable(false);
        Main.window.setOnCloseRequest(e -> Platform.exit());
        Main.window.show();
    }

    public static void Telegram() throws IOException, URISyntaxException {
        openLink("https://t.me/MightyOdinSon");
    }

    public static void Github() throws IOException, URISyntaxException {
        openLink("https://github.com/AjithRamachandran/WikiPlus");
    }

    public static void Instagram() throws IOException, URISyntaxException {
        openLink("https://www.instagram.com");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
