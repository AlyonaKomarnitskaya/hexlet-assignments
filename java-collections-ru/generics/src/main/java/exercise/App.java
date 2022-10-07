package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> bookList, Map<String, String> booksContent) {
        List<Map<String, String>> finalBookList = new ArrayList<>();
        for (Map<String, String> book: bookList) {
                if (book.entrySet().containsAll(booksContent.entrySet())) {
                    finalBookList.add(book);
            }
            }
        return finalBookList;
    }
}
//END
