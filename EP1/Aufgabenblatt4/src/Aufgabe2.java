/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        short[] shortArray = new short[]{3, 6, 24, 31, 35, 44, 67, 73, 89, 92};
        printShortArrayWithSeparator(shortArray);

        char[] charArray = new char[]{'a', '8', '8', 'G', '2', ':', ':', ':', 'F', '7', 'b', 'b', '-', 'T'};
        char[] newCharArray = new char[charArray.length + checkForSimilarElements(charArray)];
        fillNewCharArray(charArray, newCharArray);
        printCharArray(newCharArray);

        byte[] byteArray = new byte[20];
        fillArrayReverse(byteArray, (byte) 19, (byte) 0);
        printByteArrayWithForLoop(byteArray);
        printByteArrayWithWhileLoop(byteArray);
    }

    private static void printShortArrayWithSeparator(short[] shortArray) {
        System.out.print("|");
        for (int i = 0; i < shortArray.length; i++) {
            System.out.print(shortArray[i]);
            if (i < shortArray.length - 1) {
                System.out.print(";");
            }
        }
        System.out.println("|");
    }

    private static int checkForSimilarElements(char[] charArray) {
        int counter = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (i > 0) {
                if (charArray[i] == charArray[i - 1]) {
                    counter += 1;
                }
            }
        }
        return counter;
    }

    private static void fillNewCharArray(char[] charArray, char[] newCharArray) {
        int newCharArrayIndex = newCharArray.length - 1;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (i > 0) {
                newCharArray[newCharArrayIndex] = charArray[i];
                if (charArray[i] == charArray[i - 1]) {
                    newCharArray[newCharArrayIndex - 1] = '+';
                    newCharArrayIndex--;
                }
                newCharArrayIndex--;
            } else {
                newCharArray[newCharArrayIndex] = charArray[i];
            }
        }
    }

    private static void printCharArray(char[] charArray) {
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i] + " ");
        }
        System.out.println();
    }

    private static void fillArrayReverse(byte[] byteArray, byte start, byte end) {
        for (byte i = start; i >= end; i--) {
            byteArray[i] = i;
        }
    }

    private static void printByteArrayWithForLoop(byte[] byteArray) {
        System.out.println("for-loop:");
        for (int i = 0; i < byteArray.length; i++) {
            if (i < byteArray.length - 1) {
                System.out.print(byteArray[i] + "!");
            } else {
                System.out.print(byteArray[i]);
            }
        }
        System.out.println();
    }

    private static void printByteArrayWithWhileLoop(byte[] byteArray) {
        System.out.println("while-loop:");
        int arrayIndex = 0;
        while (arrayIndex < byteArray.length) {
            if (arrayIndex < byteArray.length - 1) {
                System.out.print(byteArray[arrayIndex] + "!");
            } else {
                System.out.print(byteArray[arrayIndex]);
            }
            arrayIndex++;
        }
    }
}

