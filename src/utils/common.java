package utils;

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
            URL url = new URL("https://www.geeksforgeeks.org/");
            URLConnection connection = url.openConnection();
            connection.connect();
            return false;
        }
        catch (Exception e) {
            return true;
        }
    }
}
