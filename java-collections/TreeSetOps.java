import java.util.Arrays;
import java.util.Collections;
import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetOps {

    /*
     * TreeSet operations:
     * - add(value): adds a value if it is not already present.
     * - remove(value): removes a value if it exists.
     * - contains(value): checks whether a value exists.
     * - first() / last(): returns the smallest / largest value.
     * - pollFirst() / pollLast(): removes and returns the smallest / largest value.
     * - higher(value) / lower(value): returns the next greater / smaller value.
     * - ceiling(value) / floor(value): returns the nearest greater-or-equal /
     *   smaller-or-equal value.
     *
     * TreeSet:
     * - Does not allow duplicates.
     * - Keeps elements sorted.
     * - Uses natural ordering by default, or a supplied Comparator.
     * - Does not normally allow null values.
     */

    public static void main(String[] args) {
        demonstrateTreeSetOperations();
    }

    public static void demonstrateTreeSetOperations() {

        // Natural ordering: ascending order.
        NavigableSet<Integer> numbers = new TreeSet<>();
        numbers.addAll(Arrays.asList(5, 3, 6, 8, 2, 3));

        // Duplicate 3 is ignored.
        System.out.println("Numbers: " + numbers); // [2, 3, 5, 6, 8]
        System.out.println("Size: " + numbers.size()); // 5

        // Check whether an element exists.
        System.out.println("Contains 5: " + numbers.contains(5));

        // Smallest and largest values.
        System.out.println("First: " + numbers.first()); // 2
        System.out.println("Last: " + numbers.last());   // 8

        // Nearby values.
        System.out.println("Higher than 5: " + numbers.higher(5));   // 6
        System.out.println("Lower than 5: " + numbers.lower(5));     // 3
        System.out.println("Ceiling of 4: " + numbers.ceiling(4));   // 5
        System.out.println("Floor of 4: " + numbers.floor(4));       // 3

        // Remove a specific value.
        numbers.remove(5);
        System.out.println("After removing 5: " + numbers);

        // Remove smallest and largest values.
        System.out.println("Removed first: " + numbers.pollFirst());
        System.out.println("Removed last: " + numbers.pollLast());
        System.out.println("After polling: " + numbers);

        // Descending-order TreeSet using a comparator.
        NavigableSet<Integer> descendingNumbers =
                new TreeSet<>(Collections.reverseOrder());

        descendingNumbers.addAll(Arrays.asList(5, 3, 6, 8, 2));
        System.out.println("Descending: " + descendingNumbers);
        // [8, 6, 5, 3, 2]
    }
}
