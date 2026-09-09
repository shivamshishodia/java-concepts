import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TreeMapOps {

    /*
     * TreeMap operations:
     * - put(key, value): adds or updates a key-value pair.
     * - get(key): returns the value for a key.
     * - remove(key): removes a key-value pair.
     * - containsKey(key): checks whether a key exists.
     * - firstKey() / lastKey(): returns the smallest / largest key.
     * - higherKey(key) / lowerKey(key): returns the next greater / smaller key.
     * - ceilingKey(key) / floorKey(key): returns the nearest greater-or-equal /
     *   smaller-or-equal key.
     * - pollFirstEntry() / pollLastEntry(): removes and returns the entry with
     *   the smallest / largest key.
     *
     * TreeMap:
     * - Stores unique keys; values may be duplicated.
     * - Sorts entries by key, using natural ordering or a Comparator.
     * - Does not normally allow null keys.
     * - Allows null values.
     * - Most operations take O(log n).
     */

    public static void main(String[] args) {
        demonstrateTreeMapOperations();
    }

    public static void demonstrateTreeMapOperations() {

        // Keys are automatically sorted in ascending order.
        NavigableMap<Integer, String> students = new TreeMap<>();

        students.put(103, "Sneha");
        students.put(101, "Shivam");
        students.put(105, "Sunita");
        students.put(102, "Ansh");

        System.out.println("Students: " + students);
        // {101=Shivam, 102=Ansh, 103=Sneha, 105=Sunita}

        // Same key replaces its previous value.
        students.put(101, "Shishodia");

        System.out.println("Student 101: " + students.get(101));
        System.out.println("Contains key 103: " + students.containsKey(103));

        // Smallest and largest keys.
        System.out.println("First key: " + students.firstKey()); // 101
        System.out.println("Last key: " + students.lastKey());   // 105

        // Find nearby keys.
        System.out.println("Higher key than 102: " + students.higherKey(102)); // 103
        System.out.println("Lower key than 103: " + students.lowerKey(103));   // 102
        System.out.println("Ceiling key of 104: " + students.ceilingKey(104)); // 105
        System.out.println("Floor key of 104: " + students.floorKey(104));     // 103

        // Entries in a range: from 102 inclusive to 105 exclusive.
        System.out.println("Range: " + students.subMap(102, true, 105, false));
        // {102=Ansh, 103=Sneha}

        // Remove the smallest-key entry.
        System.out.println("Removed first entry: " + students.pollFirstEntry());

        // Descending key order.
        NavigableMap<Integer, String> descendingStudents =
                new TreeMap<>(Collections.reverseOrder());

        descendingStudents.putAll(students);
        System.out.println("Descending: " + descendingStudents);
    }
}
