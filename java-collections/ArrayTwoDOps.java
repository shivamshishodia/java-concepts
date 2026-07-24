import java.util.Arrays;

public class ArrayTwoDOps {

    /*
     * Two-dimensional array operations:
     * - Declare with type[][] name; for example, int[][] matrix.
     * - Access or update with array[row][column].
     * - array.length returns the number of rows.
     * - array[row].length returns the number of columns in that row.
     * - Arrays.deepToString(array) prints all rows and their values.
     * - Nested loops visit every value: the outer loop selects a row and the inner loop
     *   selects a column.
     *
     * A two-dimensional array in Java is an array of arrays.
     * Rows can have different lengths; this is called a jagged array.
     */
    public static void main(String[] args) {
        System.out.println("demonstrateTwoDimensionalArrays");
        demonstrateTwoDimensionalArrays();

        System.out.println("demonstrateJaggedArrays");
        demonstrateJaggedArrays();
    }

    public static void demonstrateTwoDimensionalArrays() {
        // A rectangular array initially creates four rows with four columns each.
        int[][] numbers = new int[4][4];

        // Replacing a row with an array of a different length makes the array jagged.
        // The original four-column row is replaced; it is not resized.
        numbers[0] = new int[]{1, 2};
        numbers[1] = new int[]{1, 2, 3, 4, 5, 6};

        System.out.println("Array: " + Arrays.deepToString(numbers));
        System.out.println("Rows: " + numbers.length);
        System.out.println("Columns in row 0: " + numbers[0].length);
        System.out.println("Values by row:");
        printTwoDimensionalArray(numbers);
    }

    public static void demonstrateJaggedArrays() {
        // A jagged array: each row can have a different number of columns.
        int[][] numbers = {
                { 1, 2, 3, 4 },
                { 2, 1 },
                { 1, 2, 3 },
                new int[4]
        };

        System.out.println("Numbers: " + Arrays.deepToString(numbers));
        System.out.println("Rows: " + numbers.length);
        System.out.println("Columns in row 0: " + numbers[0].length);

        // Read and update an element using row and column indexes.
        System.out.println("Value at row 1, column 1: " + numbers[1][1]);
        numbers[3][0] = 9;

        System.out.println("Values by row:");
        printTwoDimensionalArray(numbers);

        System.out.println("After update: " + Arrays.deepToString(numbers));
    }

    // Use array[row].length so this works for every row, including jagged arrays.
    public static void printTwoDimensionalArray(int[][] array) {
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                System.out.print(array[row][column] + " ");
            }
            System.out.println();
        }
    }
}
