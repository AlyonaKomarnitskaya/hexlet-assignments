package exercise;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emailsList) {
        int finalEmails = (int) emailsList.stream()
                .filter(email -> StringUtils.containsAny(email, "@gmail.com", "@yandex.ru", "@hotmail.com"))
                .count();
        return finalEmails;
    }
}
// END
