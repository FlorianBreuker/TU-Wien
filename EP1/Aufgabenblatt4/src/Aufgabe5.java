/*
    Aufgabe 5) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe5 {

    private static int[][] generateExtendedArray(int[] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        // based on the specification the newArray height will be set
        int arrayHeight = inputArray[1] - inputArray[0] + 1;
        int[][] result = new int[arrayHeight][];

        // every row gets iterated and a new array will be initialized inside
        for (int i = 0; i < result.length; i++) {
            // based on inputArray[0] a new array with the current amount of columns will be initialized.
            result[i] = new int[inputArray[0]];
            for (int j = 0; j < inputArray[0]; j++) {
                // every column gets iterated and set to the current number.
                result[i][j] = inputArray[2];
                // current number is incremented by 1
                inputArray[2]++;
            }
            // column size will be incremented by one
            inputArray[0]++;
        }
        return result; //Zeile kann geändert oder entfernt werden.
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int[] arr : inputArray) {
                for (int val : arr) {
                    System.out.print(val + "\t");
                }
                System.out.println();
            }
        }
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[] inputArray) {
        if (inputArray != null) {
            for (int val : inputArray) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] array1 = new int[]{1, 2, 10};
        int[][] array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{10}, {11, 12}}));
        System.out.println("-----");

        array1 = new int[]{3, 6, 8};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{8, 9, 10}, {11, 12, 13, 14}, {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24, 25}}));
        System.out.println("-----");

        array1 = new int[]{6, 8, 4};
        array1res = generateExtendedArray(array1);
        printArray(array1res);
        assert (Arrays.deepEquals(array1res, new int[][]{{4, 5, 6, 7, 8, 9}, {10, 11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22, 23, 24}}));
        System.out.println("-----");
    }
}
