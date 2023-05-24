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
        //min method - Comparator
        //example1
        Optional<User> mins = Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .min((value1, value2) -> value1.getColors().size() < value2.getColors().size() ? -1 :
                        value1.getColors().size() > value2.getColors().size() ? 1 : 0);

        mins.ifPresent(value -> System.out.println(value.getFirstname()));
        //example2
        Optional<User> min2 = Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .min(Comparator.comparing(User::getAge));
        min2.ifPresent(user -> System.out.println(user.getFirstname()));
        //example3
        OptionalInt optionalInt = IntStream.of(1, 3, 51, 2, 16).min();
        optionalInt.ifPresent(System.out::println);

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
