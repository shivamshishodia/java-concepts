import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapOps {

    /*
     * HashMap operations:
     * - put(key, value): adds a new pair or overrides the value for an existing key.
     * - putIfAbsent(key, value): adds a pair only when the key does not already exist.
     * - replace(key, value): updates a value only if the key already exists.
     * - get(key): returns the value for a key.
     * - getOrDefault(key, defaultValue): returns a fallback value if the key is absent.
     * - containsKey(key) / containsValue(value): checks whether data exists.
     * - remove(key): removes a key-value pair.
     * - clear(): removes every entry.
     *
     * HashMap uses a key's hashCode() and equals() for efficient lookups.
     * It does not guarantee insertion order.
     */

    public static void main(String[] args) {
        demonstrateBasicMapOperations();
    }

    public static void demonstrateBasicMapOperations() {
        Map<String, String> names = new HashMap<>();

        // Add key-value pairs.
        names.put("Shivam", "Sisodia");
        names.put("Sneha", "Lata");
        names.put("Sunita", "Singh");
        names.put("Tikam", "Singh");
        names.put("Ansh", null);

        // Native loop
        for(Map.Entry<String, String> ele : names.entrySet()) {
            System.out.println(ele.getKey() + " -> " + ele.getValue());
        }

        // put overrides when the same key already exists.
        names.put("Shivam", "Shishodia");

        // Adds only if the key is absent; Shivam remains "Shishodia".
        names.putIfAbsent("Shivam", "Singh");

        // Updates only if the key exists.
        names.replace("Sunita", "Rana");
        names.replace("Tushar", "Shishodia"); // Does nothing: key is absent.

        System.out.println("Names: " + names);
        System.out.println("Size: " + names.size());

        // Check keys and values.
        System.out.println("Contains key 'Shivam': " + names.containsKey("Shivam"));
        System.out.println("Contains value 'Shishodia': " + names.containsValue("Shishodia"));

        // View the map contents.
        System.out.println("Keys: " + names.keySet());
        System.out.println("Values: " + names.values());
        System.out.println("Entries: " + names.entrySet());

        // Retrieve values.
        System.out.println("Shivam's surname: " + names.get("Shivam"));
        System.out.println("Unknown surname: "
                + names.getOrDefault("Tushar", "Default"));

        // Remove entries.
        names.remove("Shivam");
        names.values().remove("Lata"); // Removes Sneha's entry.

        // Remove null values before making an immutable copy, if needed.
        names.values().removeAll(Collections.singleton(null));
        System.out.println("After removals: " + names);

        // Clear the entire map.
        names.clear();
        System.out.println("After clear: " + names);
        System.out.println("Is empty: " + names.isEmpty());
    }
}
