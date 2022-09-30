import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateChaining {

    public static void main(String[] args) {
        
        List<String> names = Arrays.asList("aashi", "aanya", "abhay", "aryan");
        String selectedPrefix = "aa";
        String alternatePrefix = "ab";

        Predicate<String> stringStartWithPrefixPred = item -> item.startsWith(selectedPrefix);
        Predicate<String> stringStartWithAlternatePrefixPred = item -> item.startsWith(alternatePrefix);
        System.out.println("Chained predicate test: " + stringStartWithPrefixPred.or(stringStartWithAlternatePrefixPred).test(names.get(0)));

    }
    
}
