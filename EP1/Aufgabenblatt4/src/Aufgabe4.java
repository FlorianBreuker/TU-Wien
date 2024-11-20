/*
    Aufgabe 4) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe4 {

    private static int[][] generateFilled2DArray(int n) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] array = new int[n][n];

        fillDiagonal(array);
        if (array.length >= 3) {
            fillSquareAroundMiddle(array);
        }

        return array; //Zeile kann geändert oder entfernt werden.
    }

    private static void fillDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            fillFromDiagonalToBottom(array, i + 1, i);
            fillFromDiagonalToTop(array, i - 1, i);
        }
    }

    private static void fillFromDiagonalToBottom(int[][] array, int row, int col) {
        for (int i = row; i < array.length; i++) {
            array[i][col] = array[i - 1][col] + 1;
        }
    }

    private static void fillFromDiagonalToTop(int[][] array, int row, int col) {
        for (int i = row; i >= 0; i--) {
            array[i][col] = array[i + 1][col] + 1;
        }
    }

    private static void fillSquareAroundMiddle(int[][] array) {
        int middleElementRow = array.length / 2;
        int middleElementCol = array[0].length / 2;

        for (int i = middleElementRow - 1; i <= middleElementRow + 1; i++) {
            for (int j = middleElementCol - 1; j <= middleElementCol + 1; j++) {
                array[i][j] = -1;
            }
        }
        array[middleElementRow][middleElementCol] = 1;
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

        int[][] array = generateFilled2DArray(1);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1}}));
        System.out.println("-----");

        array = generateFilled2DArray(3);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{-1, -1, -1}, {-1, 1, -1}, {-1, -1, -1}}));
        System.out.println("-----");

        array = generateFilled2DArray(5);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4, 5}, {2, -1, -1, -1, 4}, {3, -1, 1, -1, 3},
                {4, -1, -1, -1, 2}, {5, 4, 3, 2, 1}}));
        System.out.println("-----");

        array = generateFilled2DArray(7);
        printArray(array);
        assert (Arrays.deepEquals(array, new int[][]{{1, 2, 3, 4, 5, 6, 7}, {2, 1, 2, 3, 4, 5, 6}, {3, 2, -1, -1, -1, 4, 5},
                {4, 3, -1, 1, -1, 3, 4}, {5, 4, -1, -1, -1, 2, 3}, {6, 5, 4, 3, 2, 1, 2}, {7, 6, 5, 4, 3, 2, 1}}));
        System.out.println("-----");
        System.out.println();
    }
}
