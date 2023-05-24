import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
//    private static Predicate<String> isLenghtThreeChars= color-> color.length()==3;

    public static void main(String[] args) {
        //Consumer Functional Interface foreach

        // example 1
        // Arrays.asList(colors).forEach(System.out::println);

        // example 2
        AtomicInteger count = new AtomicInteger();
        Arrays.asList(colors).stream()
                .forEach(color -> count.addAndGet(color.length()));
        System.out.println(count.get());

        //example 3 peek
        long count3 = Arrays.asList(colors).stream()
                .filter(color -> color.length() > 5)
                .peek(color -> System.out.println("Filter value = " + color))
                .map(color -> color.toUpperCase())
                .peek(color -> System.out.println("Mapped value = " + color))
                .count();

        System.out.println(count3);

    }
}
