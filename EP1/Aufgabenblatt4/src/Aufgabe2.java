/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        short[] shortArray = new short[]{3, 6, 24, 31, 35, 44, 67, 73, 89, 92};
        printShortArrayWithSeparator(shortArray);

        char[] charArray = new char[]{'a', '8', '8', 'G', '2', ':', ':', ':', 'F', '7', 'b', 'b', '-', 'T'};
        // creates a new array with the length of the original + the space for the "+"
        char[] newCharArray = new char[charArray.length + checkForSimilarElements(charArray)];

        fillNewCharArray(charArray, newCharArray);
        printCharArray(newCharArray);

        // because I only need values between 0 and 19 I used a byte[]
        byte[] byteArray = new byte[20];
        // casting the 19 and 0 to BYTE, bc they are initialized as INT
        fillArrayReverse(byteArray, (byte) 19);
        printByteArrayWithForLoop(byteArray);
        printByteArrayWithWhileLoop(byteArray);
    }

    // Aufgabe a
    private static void printShortArrayWithSeparator(short[] shortArray) {
        System.out.print("|");
        for (int i = 0; i < shortArray.length; i++) {
            // iterates through every column of the array and prints it.
            System.out.print(shortArray[i]);
            if (i < shortArray.length - 1) {
                // as long as the last element is not reached it prints a semicolon
                System.out.print(";");
            }
        }
        System.out.println("|");
    }

    // Aufgabe b
    private static int checkForSimilarElements(char[] charArray) {
        int counter = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (i > 0) {
                // when index 1 is reached, currentValue and lastValue are compared
                if (charArray[i] == charArray[i - 1]) {
                    // if so, the counter will be incremented
                    counter += 1;
                }
            }
        }
        return counter;
    }

    private static void fillNewCharArray(char[] charArray, char[] newCharArray) {
        // beginning at the bottom of the original and new array values get compared with their neighbor
        int newCharArrayIndex = newCharArray.length - 1;
        for (int i = charArray.length - 1; i >= 0; i--) {
            newCharArray[newCharArrayIndex] = charArray[i];
            if (i > 0) {
                // as long as index 0 is not reached, values get compared
                if (charArray[i] == charArray[i - 1]) {
                    // if they are equal, a plus will be places between
                    newCharArray[newCharArrayIndex - 1] = '+';
                    // because of the new element in the array, the index of the newArray must be shifted two steps to
                    // the left.
                    newCharArrayIndex--;
                }
                newCharArrayIndex--;
            }
        }
    }

    private static void printCharArray(char[] charArray) {
        // separated with a space, each element gets printed out on the console
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
        System.out.println();
    }

    // Aufgabe c
    private static void fillArrayReverse(byte[] byteArray, byte start) {
        byte currentValue = start;
        for (byte i = 0; i < byteArray.length; i++) {
            // it iterates through the array and sets currentValue into the current index
            byteArray[i] = currentValue;
            currentValue--;
        }
    }

    private static void printByteArrayWithForLoop(byte[] byteArray) {
        System.out.println("for-loop:");
        for (int i = byteArray.length-1; i >= 0; i--) {
            if (i > 0) {
                System.out.print(byteArray[i] + "!");
            } else {
                System.out.print(byteArray[i]);
            }
        }
        System.out.println();
    }

    private static void printByteArrayWithWhileLoop(byte[] byteArray) {
        System.out.println("while-loop:");
        int arrayIndex = byteArray . length - 1;
        while (arrayIndex >= 0) {
            if (arrayIndex > 0) {
                // every item gets printed reverse
                // as long as the first element is not reached, a separator will be printed
                System.out.print(byteArray[arrayIndex] + "!");
            } else {
                System.out.print(byteArray[arrayIndex]);
            }
            arrayIndex--;
        }
    }
}

