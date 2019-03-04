package utils;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.net.URISyntaxException;

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

    public static void openLink(String url) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URL(url).toURI());
        }
    }
