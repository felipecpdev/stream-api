import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    public static void main(String[] args) {
        //sorted
        Arrays.asList(colors).stream()
                .sorted()
                .forEach(System.out::println);

    }
}
