# Java 8 Stream API

## Basic stream operations
``` Java
//lista ejemplo
private static final String[] colors = {"Red", "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet"};
```

### Count

``` Java
//long count = Arrays.stream(colors).count();
//long count = Arrays.asList(colors).stream().count();
  long count = Stream.of(colors).count();
  System.out.println(count);
```

### Distinct

``` Java
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
```

### Limit

```java
    //limit()
        long count = Arrays.asList(colors).stream()
                .limit(4)
                .count();
        System.out.println(count);

        Stream.of(colors)
                .limit(5)
                .forEach(System.out::println);
```

### skip

```java
//skip()
        Arrays.asList(colors).stream()
                .skip(2)
                .forEach(System.out::println);
```

### findFirst()

```java
 //findFirst()
        Optional<String> first = Arrays.asList(colors).stream()
            .findFirst();
        if (first.isPresent()){
            System.out.println(first.get());
        }else{
            System.out.println("Not present");
        }
```

### findAny()

```java
 //findAny()
        Optional<String> first = Arrays.asList(colors).stream()
                .findAny();
        if (first.isPresent()){
            System.out.println(first.get());
        }else{
            System.out.println("Not present");
        }
```

### Sorted
```java
 //sorted
        Arrays.asList(colors).stream()
                .sorted()
                .forEach(System.out::println);
```

## Stream operations using the Predicate Functional Interface

### Filter-Predicate

```java
//Predicate
        long count= Arrays.asList(colors).stream()
                .filter(color->color.length()==3)
                .count();
        System.out.println(count);
        
        Predicate<String> isLenghtThreeChars= color-> color.length()==3;
        long count1= Arrays.asList(colors).stream()
                .filter(isLenghtThreeChars)
                .count();
        System.out.println(count1);
```

### allMatch

```java
        Predicate<String> isLenghtThreeChars= color-> color.length()==3;
        boolean colorsLengthEqualthree=Arrays.asList(colors).stream()
        .allMatch(isLenghtThreeChars);
        System.out.println(colorsLengthEqualthree);
```

### anyMatch

```java
        Predicate<String> isLenghtThreeChars = color -> color.length() == 3;
        boolean colorsLengthEqualthree = Arrays.asList(colors).stream()
                .anyMatch(isLenghtThreeChars);
        System.out.println(colorsLengthEqualthree);
```

### noneMatch

```java
        //noneMatch
        Predicate<String> isLenghtThreeChars = color -> color.length() == 1;
        boolean colorsLengthEqualthree = Arrays.asList(colors).stream()
        .noneMatch(isLenghtThreeChars);
        System.out.println(colorsLengthEqualthree);
```

#### Example

```java
//example
        Predicate<String> containsCharA = color -> !color.contains("a");
        Predicate<String> lessThanFiveChars = color -> color.length() > 5;
        Predicate<String> greaterThanFiveCharsAndNotContainsCharA = lessThanFiveChars.and(containsCharA);
        long count = Arrays.asList(colors).stream()
                .filter(greaterThanFiveCharsAndNotContainsCharA)
                .count();
        System.out.println(count);
```

## The Consumer

```java
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
```

## Function

*clase ejemplo*
```java
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

class Vehicle{
    private String owner;
    Vehicle(String owner){
        this.owner=owner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "owner='" + owner + '\'' +
                '}';
    }
}

```

### Map

```java
 //Map - Functional Interface example 1
        Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .filter(user -> user.getAge() > 30)
                .peek(username -> System.out.println("user over 30: " + username.getFirstname()))
                .map(User::getFirstname)
                .peek(username -> System.out.println("Mapped to String: " + username))
                .distinct()
                .forEach(System.out::println);
```

```java
 //Map to new Object - example 2
        Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .filter(user -> user.getAge() > 30)
                .map(user -> new Vehicle(user.getFirstname()))
                .forEach(System.out::println);
```

### MaptoInt

```java
//mapToInt
        IntStream intStream=Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .mapToInt(user->user.getAge());
        System.out.println(intStream.summaryStatistics());
```

### flatMap

```java
//flatMap
        Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .flatMap(user -> user.getColors().stream())
                .filter(color -> color.length() > 4)
                .distinct()
                .forEach(System.out::println);
```

### flatMapToDouble

```java
//flatMapToDouble
        OptionalDouble average = Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .flatMapToDouble(user -> DoubleStream.of(user.getColors().stream()
                        .mapToDouble(color -> color.length()).sum()))
                .peek(value -> System.out.println("Val = " + value))
                .average();
        average.ifPresent(ave -> System.out.println("Avg is :" + ave));
```
ejemplos
```java
flatMap(user->user.getColors.stream().sorted().limit(2))
```

## Comparator

### Max
```java
//max method - Comparator
        OptionalInt maxa = Arrays.asList(14, 53, 53, 13, 12, 3).stream()
                .mapToInt(value -> value)
                .max();
        maxa.ifPresent(System.out::println);

        OptionalDouble avgIntStream = IntStream.of(14, 35, 36, 3, 21, 1).average();
        avgIntStream.ifPresent(System.out::println);
```

### Min
```java

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

```

### sorted
```java
     //sorted - Comparator
        Arrays.asList(
                        new User("Tony", 45, Arrays.asList("Red", "Green")),
                        new User("Mark", 21, Arrays.asList("Blue", "Green", "White")),
                        new User("Ben", 19, Arrays.asList("Green", "Violet", "Purple", "Grey")),
                        new User("Claire", 37, Arrays.asList("White", "Black")),
                        new User("Sarah", 49, Arrays.asList("Red", "Green", "Blue"))
                ).stream()
                .sorted(Comparator.comparing(User::getFirstname))
                .map(User::getFirstname)
                .forEach(System.out::println);
```

## BinaryOperator

### reduce

```java
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
```