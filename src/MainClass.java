import java.util.Arrays;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    public static void main(String[] args) {
        //skip()
        Arrays.asList(colors).stream()
                .skip(2)
                .forEach(System.out::println);



    }
}
