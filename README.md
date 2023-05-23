# Java 8 Stream API

## Basic stream operations

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


