package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");
    public static void main(String[] args) {
        int[] numbers = {10, -4, 67, 100, -100, 8};

        System.out.println(App.getMinMax(numbers));
    }
    // BEGIN
    public static Map<String, Integer> getMinMax(int[] num) {
        MaxThread maxThread = new MaxThread(num);
        MinThread minThread = new MinThread(num);
        maxThread.start();
        minThread.start();

        try {
            maxThread.join();
            minThread.join();
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        Map result = Map.of("max", maxThread.getMax(), "min", minThread.getMin());

        return result;
    }
    // END
}
