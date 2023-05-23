import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};

    public static void main(String[] args) {
        //findAny()

        Optional<String> first = Arrays.asList(colors).stream()
                .findFirst();
        if (first.isPresent()){
            System.out.println(first.get());
        }else{
            System.out.println("Not present");
        }

    }
}
