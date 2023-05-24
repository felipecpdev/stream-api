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
        //of method
        //example 1
        Stream.of(1,24,4,5,6,4,6).sorted().forEach(System.out::println);

        //example 2
        Stream<Integer> stream1= Stream.of(1,1,1);
        Stream<Integer> stream2= Stream.of(1,2,3);
//        Stream.concat(stream1,stream2).forEach(System.out::println);
//
//        Stream<>

        Integer reduceConcat = Stream.concat(stream1, stream2)
                .sorted()
                .reduce(0, (integer1, integer2) -> integer1 + integer2);
        System.out.println(reduceConcat);

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        String result = letters
                .stream()
                .reduce("", (partialString, element) -> partialString + element);

        System.out.println(result);

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
