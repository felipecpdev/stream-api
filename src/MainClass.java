import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
//    private static Predicate<String> isLenghtThreeChars= color-> color.length()==3;

    public static void main(String[] args) {
        //example
        Predicate<String> containsCharA = color -> !color.contains("a");
        Predicate<String> lessThanFiveChars = color -> color.length() > 5;
        Predicate<String> greaterThanFiveCharsAndNotContainsCharA = lessThanFiveChars.and(containsCharA);
        long count = Arrays.asList(colors).stream()
                .filter(greaterThanFiveCharsAndNotContainsCharA)
                .count();
        System.out.println(count);


    }
}
