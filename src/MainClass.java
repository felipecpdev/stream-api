import java.util.Arrays;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    public static void main(String[] args) {
        //Distinct()
        long count = Arrays.asList(colors).stream()
                .distinct()
                .count();
        System.out.println(count);

        Arrays.asList(colors).stream()
                .distinct()
                .forEach(System.out::println);
        System.out.println();
        Stream.of(colors)
                .distinct()
                .forEach(System.out::println);


    }
}
