import java.util.HashSet;
import java.util.Set;

public class SetOps {

    /*
     * Set operations:
     * - add(value): adds a value if it is not already present.
     * - addAll(collection): adds all values from another collection.
     * - remove(value): removes a value if it exists.
     * - removeAll(collection): removes values that also exist in another collection.
     * - contains(value): checks whether a value exists.
     * - size(): returns the number of unique values.
     * - isEmpty(): checks whether the Set has no values.
     * - clear(): removes every value.
     * - retainAll(collection): keeps only values shared with another collection.
     *
     * A Set stores unique values; duplicates are ignored.
     * HashSet uses a value's hashCode() and equals() for efficient lookups.
     * HashSet does not guarantee insertion order.
     */
    public static void main(String[] args) {
        demonstrateSetOperations();
    }

    public static void demonstrateSetOperations() {
        Set<Integer> numbers = new HashSet<>();

        // Add values. Duplicate values are ignored.
        numbers.add(0);
        numbers.add(0);
        numbers.addAll(Set.of(1, 2, 3, 4, 5, 6));

        System.out.println("Numbers: " + numbers);
        System.out.println("Size: " + numbers.size());

        // Remove individual values and values from another collection.
        numbers.remove(0);
        numbers.removeAll(Set.of(1, 2));
        numbers.removeIf(number -> number > 5);

        System.out.println("After removals: " + numbers);
        System.out.println("Contains 3: " + numbers.contains(3));

        // Keep only values that are also present in the supplied collection.
        numbers.retainAll(Set.of(3, 4));
        System.out.println("After retainAll: " + numbers);

        // Clear the entire set.
        numbers.clear();
        System.out.println("After clear: " + numbers);
        System.out.println("Is empty: " + numbers.isEmpty());
    }
}
