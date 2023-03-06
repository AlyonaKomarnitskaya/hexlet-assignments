package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] numbers;
    private int minimum;

    MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        minimum = min;
    }

    public int getMin() {
        return minimum;
    }
}
// END
