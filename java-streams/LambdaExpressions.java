import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@FunctionalInterface
interface Addable {
    int add(int a,int b);  
}

public class LambdaExpressions {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);

        Consumer<Integer> printNums = (item) -> { System.out.print(item + " "); };
        nums.forEach(printNums);
        System.out.println();
        
        nums.forEach((item) -> { System.out.print(item + " ");});
        System.out.println();
        
        Addable ad1 = (a, b) -> (a + b);
        System.out.println(ad1.add(10, 20));
        
        Addable ad2 = (int a, int b) -> {
            return (a + b);
        };
        System.out.println(ad2.add(100, 200));

    }

}