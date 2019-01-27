package WikiPlus;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResultListController {
    private static String searchText;
    private Map<String, String> wordsAndDescriptions = new HashMap<>();

    @FXML private ListView<String> tempList;

    static void setSearchText(String text) {
        searchText = text;
    }

    public static void setMenuItems(String uName) {
    }

    private String getResults(String text) {
//        metacall_load_from_file('py', [ 'wiki.py' ]);
//        String result = metacall('instant_search', text);
//        return String;
        return "Hi This is a Test";
    }

    private void getOptions() {
//        metacall_load_from_file('py', [ 'wiki.py' ]);
//        String result = metacall('get_options', searchText);
//        for(String text: result) {
//            String instantResult = getResults(text);
//            wordsAndDescriptions.put(text, instantResult);
        for(int i=0; i<20;  i++) {
            String text = "Text" + i;
            String instantResult = "instantResult" + i;
            wordsAndDescriptions.put(text, instantResult);
        }
        if(wordsAndDescriptions.isEmpty()) {
            wordsAndDescriptions.put("Not Found", "The Keyword you search is not found in Wikipedia! :(");
        }
    }

    @FXML
    private void initialize() {
        getOptions();
        for (Map.Entry<String, String> entry : wordsAndDescriptions.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String item = key + "\n" + value;
            tempList.getItems().add(item);
        }
    }

    @FXML
    private void showFullContent() throws IOException {
        String text = tempList.getSelectionModel().getSelectedItem();
        String[] keywords = text.split("\\r?\\n");
        String keyword = keywords[0];
//        metacall_load_from_file('py', [ 'wiki.py' ]);
//        String result = metacall('search', keyword);
        String result = "This is a Test This is a Test This is a Test This is a Test This is a Test This is a Test This is a Test This is a Test This is a Test";
        ResultController.setResultText(result);
        Main.showScene("Result.fxml");
    }

    @FXML
    private void home() throws IOException {
        Main.showScene("Search.fxml");
    }
}
