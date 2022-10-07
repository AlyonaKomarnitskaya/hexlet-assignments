package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String finalLine) {
        return finalLine.lines()
        .filter(list -> list.startsWith("environment="))
                .map(list -> list.replaceAll("\"", ""))
                .map(list -> list.replaceAll("environment=", ""))
                .map(list -> list.split(","))
                .flatMap(Arrays::stream)
        .filter(list -> list.startsWith("X_FORWARDED_"))
                .map(list -> list.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));


    }
}
//END
