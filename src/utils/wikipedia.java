package utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

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

    public static ArrayList<String> options(String key) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        data.add(key);
        String keyWord = "https://en.wikipedia.org/wiki/" + key;
        Connection.Response resp = Jsoup.connect(keyWord).execute();
        String html = resp.body();
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        Elements cl = body.getElementsByClass("div-col");
        Elements links = cl.select("li > a");
        for (Element link : links) {
            String url = link.attr("href");
            url = url.replaceAll("_", " ").replaceAll("/wiki/", "");
            data.add(url);
        }
        return data;
    }
}
