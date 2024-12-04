/*
    Aufgabe 3) Zweidimensionale Arrays
*/

import java.util.Random;

public class Aufgabe3 {

    private static boolean[][] genAnimalCompound(int compoundSize, float probability) {

        Random myRand = new Random(5); // Diese Zeile nicht verändern!

        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        boolean[][] animalCompound = new boolean[compoundSize][compoundSize];

        for (int i = 0; i < animalCompound.length; i++) {
            for (int j = 0; j < animalCompound[i].length; j++) {
                float randomFloat = myRand.nextFloat();
                if (randomFloat <= probability) {
                    animalCompound[i][j] = true;
                } else {
                    animalCompound[i][j] = false;
                }
            }
        }
        return animalCompound; //Zeile kann geändert oder entfernt werden.
    }

    private static int[][] calcAnimalDensity(boolean[][] animalCompound) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        int[][] animalDensity = new int[animalCompound.length][animalCompound.length];

        for (int i = 0; i < animalDensity.length; i++) {
            for (int j = 0; j < animalCompound.length; j++) {
                boolean[][] currentArea = get3x3FieldAroundCurrentCell(animalCompound, i, j);
                animalDensity[i][j] = getDensity(currentArea);
            }
        }
        return animalDensity; //Zeile kann geändert oder entfernt werden.
    }

    private static boolean[][] get3x3FieldAroundCurrentCell(boolean[][] animalCompound, int animalRow, int animalColumn) {
        boolean[][] fieldAroundCell = new boolean[3][3];
        int currentRow = 0;
        int currentColumn = 0;

        for (int i = animalRow - 1; i <= animalRow + 1; i++) {
            for (int j = animalColumn - 1; j <= animalColumn + 1; j++) {
                if (i < 0 || j < 0 || i >= animalCompound.length || j >= animalCompound[i].length) {
                    fieldAroundCell[currentRow][currentColumn] = false;
                } else {
                    fieldAroundCell[currentRow][currentColumn] = animalCompound[i][j];
                }
                currentColumn++;
            }
            currentColumn = 0;
            currentRow++;
        }
        return fieldAroundCell;
    }

    private static int getDensity(boolean[][] animalCompound) {
        int density = 0;
        for (int i = 0; i < animalCompound.length; i++) {
            for (int j = 0; j < animalCompound[i].length; j++) {
                if (animalCompound[i][j]) {
                    density++;
                }
            }
        }
        return density;
    }

    // helping method for printing the animal compound
    private static void printCompound(boolean[][] animalCompound) {
        for (int y = 0; y < animalCompound.length; y++) {
            for (int x = 0; x < animalCompound[y].length; x++) {
                if (animalCompound[y][x]) {
                    System.out.print("* ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    // helping method for printing the number of animals
    private static void printDensity(int[][] animalCompound) {
        for (int y = 0; y < animalCompound.length; y++) {
            for (int x = 0; x < animalCompound[y].length; x++) {
                System.out.print(animalCompound[y][x] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // variables
        int compoundSize = 8;
        float probability = 0.5f;
        boolean[][] animalCompound = genAnimalCompound(compoundSize, probability);
        printCompound(animalCompound);
        System.out.println();
        int[][] animalDensity = calcAnimalDensity(animalCompound);
        printDensity(animalDensity);
    }
}
