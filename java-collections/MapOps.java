import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapOps {
    public static void main(String[] args) {

        // Remove null values from map. This is useful because if null values are not removed, it
        // will cause NPE issues while making immutable copies of map (in Google's Guava).
        Map<String, String> namePairs = new HashMap<>();

        namePairs.put("Shivam", "Shishodia");
        namePairs.put("Sonal", "Shishodia");
        namePairs.put("Sneha Lata", null);

        System.out.println(namePairs);

        // This will remove "Sneha Lata" as value is null
        namePairs.values().removeAll(Collections.singleton(null));
        System.out.println(namePairs);

    }
}
