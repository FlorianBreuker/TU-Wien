/*
    Aufgabe 3) Zweidimensionale Arrays
*/

import java.util.Random;

public class Aufgabe3 {

    private static boolean[][] genAnimalCompound(int compoundSize, float probability) {

        Random myRand = new Random(5); // Diese Zeile nicht verändern!

        // TODO: Implementieren Sie hier Ihre Lösung für die Methode

        // every cell in the array gets iterated. based on the seed above a float integer is randomly generated.
        // float is between 0 and 1. probability is also a value between 0 and 1.
        // based on that an if statement with less or equals is being used to simulate the randomness.
        // afterward true or false is written into the cells

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
        // now the density array is generated with the same size as animalCompound
        // for every cell a 3x3 matrix around the current cell will be generated with all direct neighbors
        // in animalCompound. Later on the density of the 3x3 is calculated and written into the densityArray

        int[][] animalDensity = new int[animalCompound.length][animalCompound.length];

        for (int i = 0; i < animalDensity.length; i++) {
            for (int j = 0; j < animalDensity[i].length; j++) {
                boolean[][] neighbors = getNeighbors(animalCompound, i, j);
                animalDensity[i][j] = getDensity(neighbors);
            }
        }
        return animalDensity; //Zeile kann geändert oder entfernt werden.
    }

    private static boolean[][] getNeighbors(boolean[][] animalCompound, int animalRow, int animalColumn) {
        // first of all a 3x3 array is being generated, bc it contains every direct neighbor of a given cell
        // afterward all 8 elements around the current cell ( plus cell on its own) will be iterated and stored
        // into the 3x3 matrix.

        boolean[][] neighbors = new boolean[3][3];
        int currentRow = 0;
        int currentColumn = 0;

        for (int i = animalRow - 1; i <= animalRow + 1; i++) {
            for (int j = animalColumn - 1; j <= animalColumn + 1; j++) {
                // first it is checked if the current index is outside animalCompound. This would be the case if the
                // current cell is a border element. Based on the instructions the values around the border cells could
                // be valued as "false".
                // all the other elements do have direct neighbors and those will be stored
                if (i < 0 || j < 0 || i >= animalCompound.length || j >= animalCompound[i].length) {
                    neighbors[currentRow][currentColumn] = false;
                } else {
                    neighbors[currentRow][currentColumn] = animalCompound[i][j];
                }
                currentColumn++;
            }
            currentColumn = 0;
            currentRow++;
        }
        return neighbors;
    }

    private static int getDensity(boolean[][] animalCompound) {
        // the neighbor matrix will now be iterated, and every true counts as a animal
        // based on that the density is incremented by one
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
