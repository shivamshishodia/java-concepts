import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Predicate (Filter) to check if array elements start with a given prefix.
// If yes then calculate distinct characters in such elemets using Mapper.

public class FilterAndMapper {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("aashi", "aanya", "abhay", "aryan");
        String selectedPrefix = "aa";

        // Call to static methods of a class having Predicate and Function.
        // Function takes in String and outputs Long.
        names.stream()
                .filter(Filter.stringStartWithPrefix(selectedPrefix))
                .map(Mapper.countDistinctCharacters())
                .parallel()
                .forEach(System.out::println);

        // Call to static methods of a class having Predicate and Function.
        // Function takes in String and outputs Long.
        // Consumer takes in Long.
        // We use parallel() and then forEachOrdered().
        names.stream()
                .filter(Filter.stringStartWithPrefix(selectedPrefix))
                .map(Mapper.countDistinctCharacters())
                .parallel()
                .forEachOrdered(Print.printCount());

        // Call to static methods of a class having Predicate and Function.
        // Function takes in String and outputs object of CharactersCount class.
        // Consumer takes in object of CharactersCount class.
        // We use parallel() and then forEach().
        names.stream()
                .filter(Filter.stringStartWithPrefix(selectedPrefix))
                .map(Mapper.distinctCharactersCount())
                .parallel()
                .forEach(Print.printCharactersCount());

        // Alternatively, you can define Predicates, Functions and Consumers using Lambda expressions.
        // Predicate should always return a boolean value.
        Predicate<String> startsWith = (item) -> {
            return item.startsWith(selectedPrefix);
        };

        // Function should always return a value provided as the second parameter (here String of <String, *String*>).
        Function<String, String> convertToStringWithDetails = (item) -> {
            return ("via Lambda expressions: \"" + item + "\" has " + item.chars().distinct().count() + " distinct characters.");
        };

        // Consumer never returns a value explicitly.
        Consumer<String> printDetails = (item) -> {
            System.out.println(item);
        };

        names.stream()
                .filter(startsWith)
                .map(convertToStringWithDetails)
                .forEach(printDetails);
    }

}

class CharactersCount {

    private final String name;
    private final Integer distinctCharacterCount;

    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }

}

class Print {

    public static Consumer<Long> printCount() {
        return item -> System.out.println("printCount consumer: " + item);
    }

    public static Consumer<CharactersCount> printCharactersCount() {
        return item -> System.out.println("printCharactersCount consumer: " + item.toString());
    }

}

class Filter {
    public static Predicate<String> stringStartWithPrefix(String prefix) {
        return item -> item.startsWith(prefix);
    }
}

class Mapper {

    public static Function<String, Long> countDistinctCharacters() {
        return item -> item.chars().distinct().count();
    }

    public static Function<String, CharactersCount> distinctCharactersCount() {
        return item -> new CharactersCount(item, (int) item.chars().distinct().count());
    }

}
