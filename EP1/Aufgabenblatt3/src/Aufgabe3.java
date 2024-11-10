/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printOddNumbersAscending(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (start <= end) {
            printOddNumbersAscending(start + 1, end);
        }
        if (start % 2 != 0) {
            System.out.print(start + " ");
        }
    }

    private static void printEvenNumbersDescending(int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (end >= 0){
            if (end % 2 == 0) {
                System.out.print(end + " ");
            }
            printEvenNumbersDescending(end - 1);
        }

    }

    private static int countCharChanges(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (text.length() <= 1){
            return 0;
        } else {
            if (text.charAt(0) != text.charAt(1)){
                return countCharChanges(text.substring(1)) + 1;
            } else {
                return countCharChanges(text.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        printOddNumbersAscending(5, 14);
        System.out.println();
        printEvenNumbersDescending(11);
        System.out.println();

        System.out.println(countCharChanges("A"));
        System.out.println(countCharChanges("AA"));
        System.out.println(countCharChanges("abBc"));
        System.out.println(countCharChanges("XYYYZZAAAB"));
        System.out.println(countCharChanges("satt"));
        System.out.println(countCharChanges("Schifffahrt"));
        System.out.println();

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (countCharChanges("A") == 0);
        assert (countCharChanges("AA") == 0);
        assert (countCharChanges("abBc") == 3);
        assert (countCharChanges("XYYYZZAAAB") == 4);
        assert (countCharChanges("satt") == 2);
        assert (countCharChanges("Schifffahrt") == 8);
        //**********************************************************************
    }
}

