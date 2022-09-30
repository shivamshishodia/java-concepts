import java.util.*;
import java.util.stream.*;

public class FlatMapAndMap {

    public static void main(String[] args) {

        /*
         * Example 1:
         * flatMap() will merge all the below arrays into one. They will be ordered.
         */

        List<Integer> evens = Arrays.asList(2, 4, 6, 8, 10, 12); 
        List<Integer> odds = Arrays.asList(3, 5, 7, 9, 11, 13); 
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13);

        List<Integer> numbers = Stream.of(evens, odds, primes)
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        // Flattend list of 'numbers' (Stream.of()): [2, 4, 6, 8, 10, 12, 3, 5, 7, 9, 11, 13, 2, 3, 5, 7, 11, 13]
        System.out.println("Flattend list of 'numbers' (Stream.of()): " + numbers);

        /*
         * Example 2:
         */
        List<List<Integer>> values = new ArrayList<>();
        values.add(Arrays.asList(2, 4, 6, 8, 10, 12));
        values.add(Arrays.asList(3, 5, 7, 9, 11, 13));
        values.add(Arrays.asList(2, 3, 5, 7, 11, 13));

        List<Integer> flatValues = values.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        // Flattend list of 'flatValues' (stream()): [2, 4, 6, 8, 10, 12, 3, 5, 7, 9, 11, 13, 2, 3, 5, 7, 11, 13]
        System.out.println("Flattend list of 'flatValues' (stream()): " + flatValues);

    }

}