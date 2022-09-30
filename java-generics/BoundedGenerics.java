public class BoundedGenerics {

    public static void main(String[] args) {

        /*
         * Note: Primitive data types do not work with generics.
         * Below, you can only use Car, Tesla or Mercedes (child classes of Car).
         */ 

        BoundedPrinter<Tesla> teslaPrinter = new BoundedPrinter<Tesla>(new Tesla("Hi, Tesla!"));
        System.out.println("teslaPrinter: " +  teslaPrinter.getValue());

        BoundedPrinter<Mercedes> mercedesPrinter = new BoundedPrinter<Mercedes>(new Mercedes("Hello! Mercedes."));
        System.out.println("mercedesPrinter: " +  mercedesPrinter.getValue());

        /*
         * NOTE: String is not child class of Car and hence the below code will not work.
         * BoundedPrinter<String> stringPrinter = new BoundedPrinter<String>("Hello, World!");
         * System.out.println("stringPrinter: " +  stringPrinter.getValue());
         */
        
    }
    
}

/*
 * You can also name this class BoundedPrinter<AnythingWillWork>
 * T can extend both, an interface and class. They should be seperated by '&'
 */
class BoundedPrinter<T extends Car> {

    // Data member
    T valueToPrint;

    // Constructor
    BoundedPrinter(T valueToPrint) {
        this.valueToPrint = valueToPrint;
    }

    // Method
    public T getValue() {
        // You can also reference extended class methods.
        System.out.println(valueToPrint.getCompanyName());
        return this.valueToPrint;
    }

}

// Car is a superclass for Tesla and Mercedes.
class Car {

    private String companyName;

    Car() {
    }

    Car(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return this.companyName;
    }

}

class Tesla extends Car {

    Tesla(String companyName) {
        super(companyName);
    }

}

class Mercedes extends Car {

    Mercedes(String companyName) {
        super(companyName);
    }

}
