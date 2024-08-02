import java.util.*;
import java.util.stream.*;

public class PartitioningBy {

    public static void main(String[] args) {

        // partitioningBy is used to divide the data into two partitions. It accepts a Predicate.
        List<String> fruits = List.of("apple", "orange", "banana", "pear");

        // Partition fruits by length.
        Map<Boolean, List<String>> partitionedFruitsByLength = fruits.stream()
                .collect(Collectors.partitioningBy(fruit -> fruit.length() > 4));

        // partitionedFruitsByLength : {false=[pear], true=[apple, orange, banana]}
        System.out.println("partitionedFruitsByLength : " + partitionedFruitsByLength);

        // Partition fruits by length and count.
        Map<Boolean, Long> partitionedFruitsByLengthAndCount = fruits.stream()
                .collect(Collectors.partitioningBy(fruit -> fruit.length() > 4, Collectors.counting()));

        // partitionedFruitsByLengthAndCount : {false=1, true=3}
        System.out.println("partitionedFruitsByLengthAndCount : " + partitionedFruitsByLengthAndCount);

        // Partition fruits by length and change to upper case.
        Map<Boolean, List<String>> partitionedFruitsInUpperCaseByLength = fruits.stream()
                .collect(Collectors.partitioningBy(fruit -> fruit.length() > 4,
                        Collectors.mapping(String::toUpperCase, Collectors.toList())));

        // partitionedFruitsInUpperCaseByLength : {false=[PEAR], true=[APPLE, ORANGE, BANANA]}
        System.out.println("partitionedFruitsInUpperCaseByLength : " + partitionedFruitsInUpperCaseByLength);

        // Partition fruits by length and starts with check.
        Map<Boolean, List<String>> partitionedFruitsByLengthAndStartsWith = fruits.stream()
                .collect(Collectors.partitioningBy(fruit -> fruit.length() > 4 && fruit.startsWith("a")));

        // partitionedFruitsByLengthAndStartsWith : {false=[orange, banana, pear], true=[apple]}
        System.out.println("partitionedFruitsByLengthAndStartsWith : " + partitionedFruitsByLengthAndStartsWith);

    }

}
