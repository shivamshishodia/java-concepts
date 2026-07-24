import java.util.ArrayList;
import java.util.List;

public class ListOps {

    /*
     * List operations:
     * - add(value) / add(index, value): adds a value at the end or at a specific position.
     * - addAll(collection): adds all values from another collection.
     * - get(index): returns the value at an index.
     * - set(index, value): replaces the value at an index.
     * - contains(value) / containsAll(collection): checks whether values exist.
     * - indexOf(value) / lastIndexOf(value): finds the first or last matching index.
     * - remove(value) / remove(index): removes a value or the value at an index.
     * - removeIf(predicate): removes values that match a condition.
     * - sort(comparator): sorts the values.
     * - size() / isEmpty(): returns the number of values or checks whether the List is empty.
     * - clear(): removes every value.
     *
     * A List preserves insertion order and allows duplicate values.
     * ArrayList stores values in a resizable array and supports fast index-based access.
     */
    public static void main(String[] args) {
        demonstrateListOperations();
    }

    public static void demonstrateListOperations() {
        List<String> names = new ArrayList<>();

        // Add values. Lists preserve order and allow duplicates.
        names.addAll(List.of("Shivam", "Sonal", "Sneha", "Sunita"));
        names.add("Tikam");
        names.add(1, "Ansh");
        names.add("Shivam");

        System.out.println("Names: " + names);
        System.out.println("First name: " + names.get(0));
        System.out.println("Contains Shivam: " + names.contains("Shivam"));
        System.out.println("Contains Sonal and Sneha: "
                + names.containsAll(List.of("Sonal", "Sneha")));
        System.out.println("First Shivam index: " + names.indexOf("Shivam"));
        System.out.println("Last Shivam index: " + names.lastIndexOf("Shivam"));

        // Replace and remove values.
        names.set(0, "Shishodia");
        names.remove("Shivam");
        names.removeIf(name -> name.startsWith("T"));
        System.out.println("After updates: " + names);

        // Sort the remaining values.
        names.sort(String::compareTo);
        System.out.println("Sorted names: " + names);
        System.out.println("Size: " + names.size());

        // Clear the entire list.
        names.clear();
        System.out.println("After clear: " + names);
        System.out.println("Is empty: " + names.isEmpty());
    }
}
