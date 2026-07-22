import java.util.Arrays;
import java.util.Comparator;

public class ArrayOneDOps {

    /*
     * String array operations:
     * - Access with array[index].
     * - Update with array[index] = value.
     * - length gives the fixed array size.
     * - Arrays.toString(array) prints contents.
     * - Arrays.sort(array) sorts the original array.
     * - Arrays.binarySearch(array, value) searches a sorted array.
     * - Arrays.copyOf(...) and copyOfRange(...) create copies.
     * - Arrays.fill(array, value) assigns one value to every element.
     * - Arrays.mismatch(first, second) returns the first different index.
     * - Arrays.setAll(array, generator) calculates each element from its index.
     *
     * Note: String is an object type, not a primitive type.
     * Arrays have fixed length, but their elements can be replaced.
     */

    public static void main(String[] args) {
        demonstrateArrayOperations();
        demonstrateComparatorSorting();
    }

    public static void demonstrateComparatorSorting() {
        String[] names = { "Shivam", "Sneha", "Sunita", "Tikam", "Ansh" };

        // Comparator utility: alphabetical order, ignoring letter case.
        Arrays.sort(names, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Alphabetical: " + Arrays.toString(names));

        // Lambda comparator: reverse alphabetical order.
        Arrays.sort(names, (first, second) -> second.compareTo(first));
        System.out.println("Reverse alphabetical: " + Arrays.toString(names));

        // Comparator utility: sort by name length.
        Arrays.sort(names, Comparator.comparingInt(String::length));
        System.out.println("By length: " + Arrays.toString(names));

        // Lambda comparator: sort by length, then alphabetically for ties.
        Arrays.sort(names, (first, second) -> {
            int lengthComparison = Integer.compare(first.length(), second.length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return first.compareTo(second);
        });

        System.out.println("By length, then name: " + Arrays.toString(names));
    }

    public static void demonstrateArrayOperations() {
        String[] names = { "Shivam", "Sneha", "Sunita", "Tikam" };

        // Read and update an element.
        System.out.println("First name: " + names[0]);
        names[0] = "Bobby";
        System.out.println("After update: " + Arrays.toString(names));

        // Get the fixed array length.
        System.out.println("Length: " + names.length);

        // Enhanced for-loop.
        System.out.println("Names:");
        for (String name : names) {
            System.out.println(name);
        }

        // Traditional loop when the index is needed.
        System.out.println("Names with indexes:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + ": " + names[i]);
        }

        // Sort alphabetically. This changes the original array.
        Arrays.sort(names);
        System.out.println("Sorted names: " + Arrays.toString(names));

        // binarySearch requires the array to be sorted first.
        int index = Arrays.binarySearch(names, "Sneha");
        System.out.println("Index of Sneha: " + index);

        int missingIndex = Arrays.binarySearch(names, "Charlie");
        System.out.println("Search result for Charlie: " + missingIndex);
        // A negative result means the value was not found.

        // Copy the entire array or a specified range.
        String[] copy = Arrays.copyOf(names, names.length);
        String[] firstTwo = Arrays.copyOfRange(names, 0, 2);

        System.out.println("Full copy: " + Arrays.toString(copy));
        System.out.println("First two: " + Arrays.toString(firstTwo));

        // Fill every array position with the same value.
        Arrays.fill(copy, "Unknown");
        System.out.println("Filled copy: " + Arrays.toString(copy));

        // Find the first different value between two arrays. (Java 9+)
        String[] a = { "red", "green", "blue" };
        String[] b = { "red", "yellow", "blue" };

        int mismatchIndex = Arrays.mismatch(a, b);
        System.out.println("First mismatch index: " + mismatchIndex); // 1

        // Generate values based on their indexes.
        String[] labels = new String[4];
        Arrays.setAll(labels, i -> "Item-" + (i + 1));

        System.out.println("Generated labels: " + Arrays.toString(labels));
    }
}
