/*
    Aufgabe 6) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe6 {

    private static int[][] generateReformattedArray(int[][] inputArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] result = new int[inputArray.length][];

        for (int i = 0; i < result.length; i++) {
            // to get the currentIndex of each row I stored the last index for every row here
            int lastIndex = 0;
            // according to specification every row can get a different amount of columns
            int amountOfCols = getNewArraysCols(inputArray, i);
            result[i] = new int[amountOfCols];
            for (int j = 0; j < inputArray[i].length; j += 2) {
                // the current row is iterated through every EVEN index
                // as mentioned before every EVEN index holds the amount of the following column, so I store the amount
                // and the value
                int amount = inputArray[i][j];
                int value = inputArray[i][j + 1];
                // then, I add the amount of values to the result array and store the lastIndex
                lastIndex = addFormattedRows(result, i, amount, value, lastIndex);
            }
        }
        return result; //Zeile kann geändert oder entfernt werden.
    }

    private static int getNewArraysCols(int[][] formattedArray, int i) {
        // according to the specification EVEN INDEX holds the appearances of the following INT
        // based on that, those appearances will be summed up, so the amount of columns is calculated
        int cols = 0;
        for (int j = 0; j < formattedArray[i].length; j++) {
            if (j % 2 == 0) {
                cols += formattedArray[i][j];
            }
        }
        return cols;
    }

    private static int addFormattedRows(int[][] formattedArray, int row, int amount, int value, int lastIndex) {
        for (int i = lastIndex; i < (lastIndex + amount); i++) {
            // beginning at lastIndex, the value gets added to the array based on the amount
            formattedArray[row][i] = value;
        }
        // new index will be returned
        return lastIndex + amount;
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

        int[][] array2 = new int[][]{{1, 1, 1, 0, 2, 1}, {1, 0, 2, 1}, {1, 0, 1, 1, 1, 0, 2, 1},
                {3, 0, 1, 1, 1, 0}, {1, 1, 1, 0}, {5, 1}};
        System.out.println("Before:");
        printArray(array2);
        int[][] array2res = generateReformattedArray(array2);
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        assert (Arrays.deepEquals(array2res, new int[][]{{1, 0, 1, 1}, {0, 1, 1}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 0}, {1, 0}, {1, 1, 1, 1, 1}}));
        System.out.println("-----");


        System.out.println();
        array2 = new int[][]{{1, 1, 1, 0, 2, 1, 4, 0}, {1, 0, 5, 1, 2, 0}, {6, 0, 2, 1},
                {1, 1, 7, 0}, {4, 0, 2, 1, 1, 0, 1, 1}, {8, 0}, {7, 0, 1, 1}};
        System.out.println("Before:");
        printArray(array2);
        array2res = generateReformattedArray(array2);
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        assert (Arrays.deepEquals(array2res, new int[][]{{1, 0, 1, 1, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1}}));
        System.out.println("-----");


        System.out.println();
        array2 = new int[][]{{1, 0}, {1, 1}, {2, 0}, {1, 0, 1, 1}, {1, 1, 1, 0}, {2, 1}};
        System.out.println("Before:");
        printArray(array2);
        array2res = generateReformattedArray(array2);
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        assert (Arrays.deepEquals(array2res, new int[][]{{0}, {1}, {0, 0}, {0, 1}, {1, 0}, {1, 1}}));
        System.out.println("-----");


        System.out.println();
        array2 = new int[][]{{12, 0}};
        System.out.println("Before:");
        printArray(array2);
        array2res = generateReformattedArray(array2);
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2res);
        assert (Arrays.deepEquals(array2res, new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
        System.out.println("-----");

    }
}
