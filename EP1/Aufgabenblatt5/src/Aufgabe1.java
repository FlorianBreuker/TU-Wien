/*
    Aufgabe 1) Zweidimensionale Arrays
*/

import java.util.Arrays;

public class Aufgabe1 {

    private static void shiftLines(int[][] workArray) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        // first case check if all elements in the array have the same length
        if (checkIfAllElementsAreSameLength(workArray)){
            shiftAllLines(workArray);
        } else {
            // get the index of the shortest line and afterward switch both lines
            switchFirstAndShortestLine(workArray);
        }
    }

    private static void shiftAllLines(int[][] workArray) {
        // creating a duplicate element of the first row for later swap
        int[] firstLine = createDuplicateOfLine(workArray,0);
        for (int i = 0; i < workArray.length - 1; i++) {
            // overwrite current line with next line
            int[] nextLine = createDuplicateOfLine(workArray,i + 1);
            workArray[i] = nextLine;
        }
        // after the shift, the last row is existing twice.
        // so the first element needs to be pushed in the last row
        workArray[firstLine.length-1] = firstLine;
    }

    private static int getShortestLine (int[][] workArray) {
        // checks if the current line is shorter than the memorized shortestLine
        int currentShortestLineIndex = 0;
        for (int i = 0; i < workArray.length; i++) {
            if (workArray[i].length < workArray[currentShortestLineIndex].length) {
                currentShortestLineIndex = i;
            }
        }
        return currentShortestLineIndex;
    }

    private static void switchFirstAndShortestLine(int[][] workArray) {
        // gets the shortest row in the array
        // afterward a copy of the first and the shortest line is created
        // then both lines get swapped

        int shortestLineIndex = getShortestLine(workArray);
        int[] shortestLine = createDuplicateOfLine(workArray,shortestLineIndex);
        int[] firstLine = createDuplicateOfLine(workArray,0);

        workArray[0] = shortestLine;
        workArray[shortestLineIndex] = firstLine;
    }

    private static int[] createDuplicateOfLine(int[][] workArray, int rowIndex) {
        // creates a copy of a given row and returns this array

        int[] duplicatedLine = new int[workArray[rowIndex].length];

        for (int i = 0; i < workArray[rowIndex].length; i++) {
            duplicatedLine[i] = workArray[rowIndex][i];
        }
        return duplicatedLine;
    }

    private static boolean checkIfAllElementsAreSameLength(int[][] workArray) {
        // iterates every row in the array and checks if the next row is the same length as the current
        // if not so false will be returned
        // when the loop reaches its end, true will be return (so every line is the same length)

        for (int i = 0; i < workArray.length; i++) {
            if (i < workArray[i].length - 1) {
                if (workArray[i].length != workArray[i + 1].length) {
                    return false;
                }
            }
        }
        return true;
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

