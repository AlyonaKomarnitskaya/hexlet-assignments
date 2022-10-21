package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {

    private String sentence;
    public ReversedSequence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public int length() {
        return sentence.length();
    }

    @Override
    public char charAt(int i) {
        return sentence.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return sentence.subSequence(i, i1);
    }

    public static String toString(String sentence) {
        StringBuilder builder = new StringBuilder(sentence);
        return builder.reverse().toString();
    }
}
// END
