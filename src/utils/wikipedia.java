package utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class wikipedia {
    public static String search(String key) throws IOException {
        String keyWord = "https://en.wikipedia.org/wiki/" + key;
        Connection.Response res = Jsoup.connect(keyWord).execute();
        String html = res.body();
        Document doc2 = Jsoup.parseBodyFragment(html);
        Element body = doc2.body();
        Elements data = body.getElementsByClass("mw-parser-output");
        Elements table = data.select("p");
        return table.text();
    }
}
