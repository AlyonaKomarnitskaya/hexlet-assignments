package exercise;

import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] largeImage = Arrays.stream(image)
                .flatMap(x -> Stream.of(x, x)
                .map(j -> Arrays.stream(j)
                .flatMap(y -> Stream.of(y, y))
                .toArray(String[]::new)))
                .toArray(String[][]::new);
        return largeImage;
    }
}
// END
