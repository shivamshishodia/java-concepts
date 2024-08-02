import java.util.function.Function;

public class FunctionChaining {

    public static void main(String[] args) {

        // Function accepts input and provides an output (both are specified in the order in declaration e.g. <String, Integer>
        Function<String, Integer> func1 = item -> item.length();
        Function<Integer, Integer> func2 = item -> item * 2;

        Integer result1 = func1.andThen(func2).apply("Shivam");

        System.out.println(result1);

        // Alternatively, you can use Lambda expressions explicitly.
        Function<String, Integer> func3 = (item) -> { return item.length(); };
        Function<Integer, Integer> func4 = (item) -> { return item * 2; };

        Integer result2 = func3.andThen(func4).apply("Shivam");

        System.out.println(result2);

    }

}
