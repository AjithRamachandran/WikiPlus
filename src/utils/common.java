package utils;

import WikiPlus.Main;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class common {
    public static String toCamelCase(final String init) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split(" ")) {
            if (!word.isEmpty()) {
                ret.append(Character.toUpperCase(word.charAt(0)));
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }

    public static void openLink(String url) {
        try {
            new ProcessBuilder("x-www-browser", url).start();
        } catch (IOException ignored) {}
    }

    public static boolean isInternetAvailable() {
        try {
            URL url = new URL("https://www.google.co.in/");
            URLConnection connection = url.openConnection();
            connection.connect();
            return false;
        }
        catch (Exception e) {
            return true;
        }
    }

    public static void ResultList() throws IOException {
        Main.showScene("fxml/LoadingPage.fxml");

        Task<Parent> task = new Task<Parent>() {
            @Override
            public Parent call() throws Exception {
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

}
