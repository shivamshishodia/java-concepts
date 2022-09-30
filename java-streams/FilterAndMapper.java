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

        // Custom Predicate and Function.
        names.stream()
                .filter(Filter.stringStartWithPrefix(selectedPrefix))
                .map(Mapper.countDistinctCharacters())
                .forEach(System.out::println);

        // Custom Predicate, Function, and Consumer.
        names.stream()
                .filter(Filter.stringStartWithPrefix(selectedPrefix))
                .map(Mapper.countDistinctCharacters())
                .forEachOrdered(Print.printCount());

        // Custom Predicate and Function with object.
        names.stream()
                .filter(Filter.stringStartWithPrefix(selectedPrefix))
                .map(Mapper.distinctCharactersCount())
                .forEachOrdered(Print.printCharactersCount());

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
