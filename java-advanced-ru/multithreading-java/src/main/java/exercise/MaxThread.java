package exercise;

// BEGIN
public class MaxThread extends Thread {

    private int[] numbers;
    private int maximum;

    MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        maximum = max;
    }

    public int getMax() {
        return maximum;
    }
}
// END
