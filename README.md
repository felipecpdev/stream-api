# Java 8 Stream API

## Basic stream operations

### Count

``` Java
//       long count = Arrays.stream(colors).count();
// long count = Arrays.asList(colors).stream().count();
        long count = Stream.of(colors).count();
         System.out.println(count);
```
### Count



