import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsAlgorithms {

    /*
     * Collections operations with ArrayList:
     * - sort(list): sorts values in ascending order.
     * - binarySearch(list, value): finds a value in a sorted list.
     * - min(list) / max(list): returns the smallest or largest value.
     * - reverse(list): reverses the order of values.
     * - rotate(list, distance): shifts values right or left.
     * - shuffle(list): randomly rearranges values.
     * - swap(list, firstIndex, secondIndex): exchanges two values.
     * - copy(destination, source): copies source values into destination.
     * - fill(list, value): replaces every value with one value.
     * - disjoint(firstList, secondList): checks whether two lists share values.
     *
     * ArrayList preserves insertion order, allows duplicates,
     * and supports fast index-based access.
     */
    public static void main(String[] args) {
        demonstrateCollectionOperations();
    }

    public static void demonstrateCollectionOperations() {
        List<Integer> numbers = new ArrayList<>(List.of(7, 2, 9, 4, 1));

        System.out.println("Original numbers: " + numbers);

        // Sort the list before using binarySearch.
        Collections.sort(numbers);
        System.out.println("Sorted numbers: " + numbers);

        int index = Collections.binarySearch(numbers, 7);
        System.out.println("Index of 7: " + index);

        // Find the smallest and largest values.
        System.out.println("Minimum value: " + Collections.min(numbers));
        System.out.println("Maximum value: " + Collections.max(numbers));

        // Reverse the order.
        Collections.reverse(numbers);
        System.out.println("After reverse: " + numbers);

        // Rotate two positions to the right.
        Collections.rotate(numbers, 2);
        System.out.println("After rotate by 2: " + numbers);

        // Swap values at index 0 and index 4.
        Collections.swap(numbers, 0, 4);
        System.out.println("After swap: " + numbers);

        // Randomly rearrange the values.
        Collections.shuffle(numbers);
        System.out.println("After shuffle: " + numbers);

        // Copy source values into a destination list.
        List<Integer> source = new ArrayList<>(List.of(10, 20, 30));
        List<Integer> target = new ArrayList<>(Collections.nCopies(3, 0));

        Collections.copy(target, source);
        System.out.println("Copied target list: " + target);

        // Replace every target value with 99.
        Collections.fill(target, 99);
        System.out.println("After fill: " + target);

        // Check whether two lists have no common values.
        List<Integer> firstList = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> secondList = new ArrayList<>(List.of(4, 5, 6));

        boolean areDisjoint = Collections.disjoint(firstList, secondList);
        System.out.println("Lists are disjoint: " + areDisjoint);
    }
}
