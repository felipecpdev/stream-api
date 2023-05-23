import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
//    private static Predicate<String> isLenghtThreeChars= color-> color.length()==3;

    public static void main(String[] args) {
        //Predicate
        long count = Arrays.asList(colors).stream()
                .filter(color -> color.length() == 3)
                .count();

        System.out.println(count);
        Predicate<String> isLenghtThreeChars = color -> color.length() == 3;

        long count1 = Arrays.asList(colors).stream()
                .filter(isLenghtThreeChars)
                .count();
        System.out.println(count1);


    }
}
