import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardGenerics {

    // Use ? when the type is not known. This is better than using List<Object> lst.
    private void printList(List<?> lst) {
        lst.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    // Bounded wildcard. We use `List<? extends Item>`.
    private void printListBounded(List<? extends Item> lst) {
        lst.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args) {

        WildcardGenerics obj = new WildcardGenerics();

        // Print integer list.
        List<Integer> intList = new ArrayList<>();
        intList.addAll(Arrays.asList(1, 2, 3, 4, 5));
        obj.printList(intList);

        // Print object list.
        List<Item> itemList = new ArrayList<>();
        itemList.addAll(Arrays.asList(new Item(10), new Item(20)));
        obj.printList(itemList);

        // Bounded Print object list.
        List<Item> itemListBounded = new ArrayList<>();
        itemListBounded.addAll(Arrays.asList(new Item(10), new Item(20)));
        obj.printListBounded(itemListBounded);
        
    }
    
}

class Item {

    private Integer itemNumber;

    public Item() {
    }

    public Item(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public String toString() {
        return String.format("itemNumber: %d", this.itemNumber);
    }

}
