package WikiPlus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    static AnchorPane root;

    static List<GridPane> grid = new ArrayList<GridPane>();

    private static int currentIndex = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = (AnchorPane)FXMLLoader.load(getClass().getResource("0.fxml"));


        grid.add((GridPane)FXMLLoader.load(getClass().getResource("1.fxml")));
        grid.add((GridPane)FXMLLoader.load(getClass().getResource("2.fxml")));
        grid.add((GridPane)FXMLLoader.load(getClass().getResource("3.fxml")));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 737, 531));
        primaryStage.setMinHeight(531.0);
        primaryStage.setMinWidth(737.0);
        primaryStage.show();
    }

    private void setPane(int newIndex) {
        root.getChildren().remove(grid.get(currentIndex));
        root.getChildren().add(grid.get(newIndex))
        currentIndex = newIndex
    }

    public static void main(String[] args) {
        launch(args);
    }
}
