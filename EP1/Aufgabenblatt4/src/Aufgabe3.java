/*
    Aufgabe 3) Eindimensionale Arrays und Methoden
*/

import java.util.Arrays;

public class Aufgabe3 {

    private static void replaceValues(int[] workArray) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        // finding min and max value in the array
        int min = findMinAndMaxElement(workArray)[0];
        int max = findMinAndMaxElement(workArray)[1];

        for (int i = 0; i < workArray.length; i++) {
            // now again every element is iterated and the distance from currentElement to minValue and maxValue is
            // stored
            int diffMin = workArray[i] - min;
            int diffMax = max - workArray[i];

            // if the distance to the maxValue, is shorter, the current element gets maxValue as value
            // else the minValue will be stored
            if (diffMin > diffMax) {
                workArray[i] = max;
            } else {
                workArray[i] = min;
            }
        }
    }

    private static int[] findMinAndMaxElement (int[] workArray) {
        // iterates through the workArray and checks for every value if it's greater than max or smaller than min
        // if so, the smaller / bigger value gets stored in minMax.

        // the minValue will be stored in minMax[0]; the maxValue in minMax[1]
        int[] minMax = new int[]{workArray[0],workArray[0]};
        for (int i = 0; i < workArray.length; i++) {
            if (minMax[0] > workArray[i]){
                minMax[0] = workArray[i];
            }
            if (minMax[1] < workArray[i]){
                minMax[1] = workArray[i];
            }
        }
        return minMax;
    }
    public static void main(String[] args) {

        int[] array1 = new int[]{12, 3, 15, 18, 22, 9, 5, 8, 16, 21};
        replaceValues(array1);
        System.out.println(Arrays.toString(array1));
        assert (Arrays.equals(array1, new int[]{3, 3, 22, 22, 22, 3, 3, 3, 22, 22}));

        int[] array2 = new int[]{12, 10, 27, 18, 22, 60, 35, 36, 16, 21};
        replaceValues(array2);
        System.out.println(Arrays.toString(array2));
        assert (Arrays.equals(array2, new int[]{10, 10, 10, 10, 10, 60, 10, 60, 10, 10}));

        int[] array3 = new int[]{4, 7, 7, 4};
        replaceValues(array3);
        System.out.println(Arrays.toString(array3));
        assert (Arrays.equals(array3, new int[]{4, 7, 7, 4}));

        int[] array4 = new int[]{-5, -1, 0, 1, 5};
        replaceValues(array4);
        System.out.println(Arrays.toString(array4));
        assert (Arrays.equals(array4, new int[]{-5, -5, -5, 5, 5}));

        int[] array5 = new int[]{1,2,3};
        replaceValues(array5);
        System.out.println(Arrays.toString(array5));
        assert (Arrays.equals(array5, new int[]{1, 1, 3}));

        int[] array6 = new int[]{7};
        replaceValues(array6);
        System.out.println(Arrays.toString(array6));
        assert (Arrays.equals(array6, new int[]{7}));
    }
}
