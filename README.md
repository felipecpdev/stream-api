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