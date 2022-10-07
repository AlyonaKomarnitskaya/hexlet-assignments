package exercise;

import java.util.Arrays;
import java.util.ArrayList;

// BEGIN
public class App {
    public static boolean scrabble(String chars, String word) {
        String[] charsArray = chars.split("");
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(charsArray));
        for (int i = 0; i < word.length(); i++) {
            String currentLetter = word.substring(i, i + 1);
            if (!list.contains(currentLetter.toLowerCase())) {
                return false;
            }
            list.remove(currentLetter);
        }
        return true;
    }
}
//END
