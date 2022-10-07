package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var count = 1;
        Map<String, Integer> wordsCount = new HashMap<>();
        if (sentence == "") {
            return wordsCount;
        }
        String[] wordsArray = sentence.split(" ");
        for (String word: wordsArray) {
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }
        return wordsCount;
    }

    public static String toString(Map<String, Integer> wordsCount) {
        if (wordsCount.size() == 0) {
            return "{}";
        }
        StringBuilder wordsCountToString = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> keyAndValue : wordsCount.entrySet()) {
        wordsCountToString.append("  " + keyAndValue.getKey() + ": " + keyAndValue.getValue() + "\n");
        }
        wordsCountToString.append("}");
        return String.valueOf(wordsCountToString);
    }
}
//END
