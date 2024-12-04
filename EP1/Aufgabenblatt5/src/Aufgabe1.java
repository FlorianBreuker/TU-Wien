/*
    Aufgabe 1) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void shiftLines(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int shortestLineIndex = getShortestLine(workArray);

        if (checkIfAllElementsAreSameLength(workArray)){
            shiftAllLines(workArray);
        } else {
            switchFirstAndShortestLine(workArray, shortestLineIndex);
        }
    }

    private static void shiftAllLines(int[][] workArray) {
        int[] firstLine = createDuplicateOfLine(workArray,0);
        for (int i = 0; i < workArray.length - 1; i++) {
            int[] nextLine = createDuplicateOfLine(workArray,i + 1);
            workArray[i] = nextLine;
        }
        workArray[firstLine.length-1] = firstLine;
    }

    private static int getShortestLine (int[][] workArray) {
        int currentShortestLineIndex = 0;
        for (int i = 0; i < workArray.length; i++) {
            if (workArray[i].length < workArray[currentShortestLineIndex].length) {
                currentShortestLineIndex = i;
            }
        }
        return currentShortestLineIndex;
    }

    private static void switchFirstAndShortestLine(int[][] workArray, int shortestLineIndex) {
        int[] shortestLine = createDuplicateOfLine(workArray,shortestLineIndex);
        int[] firstLine = createDuplicateOfLine(workArray,0);

        workArray[0] = shortestLine;
        workArray[shortestLineIndex] = firstLine;
    }

    private static int[] createDuplicateOfLine(int[][] workArray, int rowIndex) {
        int[] duplicatedLine = new int[workArray[rowIndex].length];

        for (int i = 0; i < workArray[rowIndex].length; i++) {
            duplicatedLine[i] = workArray[rowIndex][i];
        }
        return duplicatedLine;
    }

    private static boolean checkIfAllElementsAreSameLength(int[][] workArray) {
        boolean lengthChecker = true;

        for (int i = 0; i < workArray.length; i++) {
            if (i < workArray[i].length - 1) {
                if (workArray[i].length == workArray[i + 1].length) {
                    lengthChecker = true;
                } else {
                    return false;
                }
            }
        }
        return lengthChecker;
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

        System.out.println("Test shiftLines:");
        System.out.println("-----");
        int[][] array1 = new int[][]{{1, 5, 6, 7}, {1, 9, 6}, {4, 3}, {6, 3, 0, 6, 9}, {6, 4, 3}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4, 3}, {1, 9, 6}, {1, 5, 6, 7}, {6, 3, 0, 6, 9}, {6, 4, 3}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{3, 2, 4, 1}, {7, 3, 6}, {4}, {5, 6, 2, 4}, {9, 1}, {3}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{4}, {7, 3, 6}, {3, 2, 4, 1}, {5, 6, 2, 4}, {9, 1}, {3}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");

        array1 = new int[][]{{3, 4, 1}, {6, 2, 5}, {9, 7, 8}};
        System.out.println("Before:");
        printArray(array1);
        shiftLines(array1);
        assert (Arrays.deepEquals(array1, new int[][]{{6, 2, 5}, {9, 7, 8}, {3, 4, 1}}));
        System.out.println("-----");
        System.out.println("After:");
        printArray(array1);
        System.out.println("-----");
    }
}

