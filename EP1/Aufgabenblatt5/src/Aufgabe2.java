/*
    Aufgabe 2) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe2 {

    private static void reformatArray(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        // first of all rows get sorted via bubble sort
        // afterward the sum column is being added and a sum calculated
        sortLines(workArray);
        getEachRow(workArray);
    }

    private static void sortLines(int[][] workArray) {
        // bubble sort
        for (int i = 0; i < workArray.length; i++) {
            for (int j = 0; j < workArray[i].length - 1; j++) {
                for (int k = 0; k < workArray[i].length - j - 1; k++) {
                    // checks if the current element is odd and the next even, if so they will be swapped
                    if (workArray[i][k] % 2 != 0 && workArray[i][k + 1] % 2 == 0) {
                        exchangeValues(workArray, i, k, k + 1);
                    }
                }
            }
        }
    }

    private static void exchangeValues(int[][] workArray, int row, int current, int next) {
        // item swap bubble sort
        int swap = workArray[row][current];
        workArray[row][current] = workArray[row][next];
        workArray[row][next] = swap;
    }

    private static void getEachRow(int[][] workArray) {
        // for every row a sum field will be added and a sum calculated
        // the new row will overwrite the current line
        for (int i = 0; i < workArray.length; i++) {
            workArray[i] = duplicateAndCalculateSum(workArray, i);
        }
    }

    private static int[] duplicateAndCalculateSum(int[][] workArray, int currentRow) {
        // a new array with current row length + 1 is created
        // the row in the work array will be iterated and all values will be sent to the new one
        // additional to that the sum gets incremented by the current value
        // as a last step the very last field in the new array gets the value of the calculated sum

        int[] duplicateRow = new int[workArray[currentRow].length + 1];
        int sum = 0;
        for (int i = 0; i < workArray[currentRow].length; i++) {
            sum += workArray[currentRow][i];
            duplicateRow[i] = workArray[currentRow][i];
        }
        duplicateRow[duplicateRow.length - 1] = sum;

        return duplicateRow;
    }

    //Vorgegebene Methode - BITTE NICHT VERÄNDERN!
    private static void printArray(int[][] inputArray) {
        if (inputArray != null) {
            for (int i = 0; i < inputArray.length; i++) {
                for (int j
                     = 0; j < inputArray[i].length; j++) {
                    System.out.print(inputArray[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Test: reformatArray");
        System.out.println("-----");
        int[][] array2 = new int[][]{{3, 4, 6, 9}, {1, 0, 2}, {3}, {2}, {4, 6, 8, 10}, {1, 3, 5, 7, 9}, {2, 7, 9, 2, 2}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{4, 6, 3, 9, 22}, {0, 2, 1, 3}, {3, 3}, {2, 2}, {4, 6, 8, 10, 28}, {1, 3, 5, 7, 9, 25}, {2, 2, 2, 7, 9, 22}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{0}, {1}, {2}, {3, 4}, {5, 7, 6}, {6, 8, 9}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{0, 0}, {1, 1}, {2, 2}, {4, 3, 7}, {6, 5, 7, 18}, {6, 8, 9, 23}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");

        array2 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, {2, 2, 2, 2, 2, 4, 4, 4, 4, 4}};
        System.out.println("Before:");
        printArray(array2);
        reformatArray(array2);
        assert (Arrays.deepEquals(array2, new int[][]{{0, 2, 4, 6, 8, 1, 3, 5, 7, 9, 45}, {2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 30}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array2);
        System.out.println("-----");
    }
}

