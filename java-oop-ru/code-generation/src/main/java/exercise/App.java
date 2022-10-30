package exercise;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        String result = car.serialize();
        Files.writeString(path, result, StandardCharsets.UTF_8);
    }

    public static Car extract(Path path) throws IOException {
        String result = Files.readString(path);
        Car fin = Car.unserialize(result);
        return fin;
    }
}
// END
