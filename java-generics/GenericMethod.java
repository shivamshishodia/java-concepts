public class GenericMethod {

    // Include <T> in the method signature.
    private <T> void shout(T valueToShout) {
        System.out.println("Shout: " + valueToShout);
    }

    // Overloaded: Include <T, V> in the method signature.
    private <T, V> void shout(T firstValueToShout, V secondValueToShout) {
        System.out.println("First Shout: " + firstValueToShout);
        System.out.println("Second Shout: " + secondValueToShout);
    }

    // With Return Type: Include <T, V> in the method signature.
    private <T, V> T shoutWithReturnValue(T firstValueToShout, V secondValueToShout) {
        System.out.println("First Shout: " + firstValueToShout);
        System.out.println("Second Shout: " + secondValueToShout);
        return firstValueToShout;
    }

    public static void main(String[] args) {

        GenericMethod obj = new GenericMethod();

        obj.shout("Hello, World!");
        obj.shout(50);
        obj.shout(35.5);
        
        // Overloaded calls.
        obj.shout("Hello, World!", "Shivam Shishodia");
        obj.shout(50, "Shivam Shishodia");
        obj.shout( 50.5, 20.5);

        // With Return Type.
        System.out.println("Return value is: " + obj.shoutWithReturnValue("Hello, World!", "Shivam Shishodia"));

    }
    
}
