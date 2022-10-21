package exercise;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildAppartmentsList(List<Home> appartaments, int n) {
        return appartaments.stream()
                .sorted(Comparator.comparing(x -> x.getArea()))
                .limit(n)
                .map(newString -> newString.toString())
                .collect(Collectors.toList());

    }
}
// END
