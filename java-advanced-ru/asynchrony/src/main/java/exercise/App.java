package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static java.nio.file.Files.readString;
import static java.nio.file.Files.writeString;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1, String file2, String file3) {
        CompletableFuture<String> getText1 = CompletableFuture.supplyAsync(() -> {
            String text = "";
            try {
                text = readString(Paths.get(file1));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return text;
        });

        CompletableFuture<String> getText2 = CompletableFuture.supplyAsync(() -> {
            String text = "";
            try {
                text = readString(Paths.get(file2));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return text;
        });

        CompletableFuture<String> mixTexts = getText1.thenCombine(getText2, (text1, text2) -> {
            String text = text1 + " " + text2;
            try {
                writeString(Paths.get(file3), text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return text;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
        return mixTexts;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        System.out.println(unionFiles("src/main/resources/file1.txt", "src/main/resources/file2.txt",
                "src/main/resources/file3.txt").get());
        // END
    }
}

