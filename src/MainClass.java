import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {
    private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
//    private static Predicate<String> isLenghtThreeChars= color-> color.length()==3;

    public static void main(String[] args) {
        //reduce - example 1
        Integer reduce = Arrays.asList(1, 2, 3, 4, 5).stream()
                .filter(integer -> integer > 2)
                .reduce(0, (subTotal, element) -> subTotal + element);
        System.out.println(reduce);

        // example 2
        Integer reduce1 = Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .filter(user -> user.getAge() > 24)
                .reduce(0, (subTotal, element) -> subTotal + element.getAge(), Integer::sum);

        System.out.println(reduce1);

        //example 3
        int reduce2 = Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .filter(user -> user.getAge() < 40)
                .flatMapToInt(user -> user.getColors().stream()
                        .mapToInt(color -> color.length()))
                .peek(numero -> System.out.println("lenght: " + numero))
                .reduce(0, (subTotal, element) -> subTotal + element);
        System.out.println(reduce2);

    }
}

class Vehicle {
    private String owner;

    Vehicle(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "owner='" + owner + '\'' +
                '}';
    }
}

class User {
    private String firstname;
    private int age;
    private List<String> colors;

    public User(String firstname, int age, List<String> colors) {
        this.firstname = firstname;
        this.age = age;
        this.colors = colors;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }
}
