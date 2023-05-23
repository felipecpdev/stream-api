import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
//    private static Predicate<String> isLenghtThreeChars= color-> color.length()==3;

    public static void main(String[] args) {
        //allMatch
        Predicate<String> isLenghtThreeChars = color -> color.length() == 3;
        boolean colorsLenthEqualthree = Arrays.asList(colors).stream()
                .allMatch(isLenghtThreeChars);
        System.out.println(colorsLenthEqualthree);

    }
}
