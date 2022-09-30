// You can also name this class GenericPrinter<AnythingWillWork>
class GenericPrinter<T> {

    // Data member
    T valueToPrint;

    // Constructor
    GenericPrinter(T valueToPrint) {
        this.valueToPrint = valueToPrint;
    }

    // Method
    public T getValue() {
        return this.valueToPrint;
    }

}

public class BasicGenerics {

    public static void main(String[] args) {

        /*
         * Note: Primitive data types do not work with generics.
         */ 

        GenericPrinter<Integer> intPrinter = new GenericPrinter<Integer>(20);
        System.out.println("intPrinter: " +  intPrinter.getValue());

        GenericPrinter<Double> doublePrinter = new GenericPrinter<Double>(35.5);
        System.out.println("doublePrinter: " +  doublePrinter.getValue());

        GenericPrinter<String> stringPrinter = new GenericPrinter<String>("Shivam Shishodia");
        System.out.println("stringPrinter: " +  stringPrinter.getValue());

        /*
         * We use generics to avoid using `GenericPrinter<Object>`
         * This is because when objects are read back, they can be of any type
         * which can lead to runtime errors.
         */

        GenericPrinter<Object> failingStringPrinter = new GenericPrinter<Object>("Cast Exception");
        System.out.println("failingStringPrinter: " +  failingStringPrinter.getValue());
        try {
            Integer failingTypeCast = (Integer) failingStringPrinter.getValue();
            System.out.println("failingTypeCast: Won't reach here. " + failingTypeCast);
        } catch (ClassCastException e) {
            System.err.println("ClassCastException: " + e.getMessage());
        }

    }

}