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
                .findAny();
        if (first.isPresent()){
            System.out.println(first.get());
        }else{
            System.out.println("Not present");
        }
```
