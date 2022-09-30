import java.util.function.Function;

public class FunctionChaining {

    public static void main(String[] args) {
        
        Function<String, Integer> func1 = item -> item.length();
        Function<Integer, Integer> func2 = item -> item * 2;

        Integer result = func1.andThen(func2).apply("Shivam");

        System.out.println(result);

    }
    
}
