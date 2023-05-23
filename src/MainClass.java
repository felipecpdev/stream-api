import java.util.Arrays;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Orange", "Green", "Blue", "Violet"};

    public static void main(String[] args) {
//        long count = Arrays.stream(colors).count();
//        long count = Arrays.asList(colors).stream().count();
        long count = Stream.of(colors).count();
        System.out.println(count);
    }
}
