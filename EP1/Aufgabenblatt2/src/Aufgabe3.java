/*
    Aufgabe 3) Schleifen und Methoden - Harshad-Zahlen
*/
public class Aufgabe3 {

    private static boolean isHarshadNumber(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int currentNumber = number;
        int checkSum = 0;
        while (currentNumber > 0){
            checkSum += currentNumber % 10;
            currentNumber /= 10;
        }
        return number % checkSum == 0; //Zeile kann geändert oder entfernt werden.
    }

    private static void printHarshadNumbersInInterval(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        for (int i = start; i <= end; i++) {
            if (isHarshadNumber(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE isHarshadNumber(...).
        System.out.println("1 --> " + isHarshadNumber(1));
        assert (isHarshadNumber(1));
        System.out.println("4 --> " + isHarshadNumber(4));
        assert (isHarshadNumber(4));
        System.out.println("13 --> " + isHarshadNumber(13));
        assert (!isHarshadNumber(13));
        System.out.println("97 --> " + isHarshadNumber(97));
        assert (!isHarshadNumber(97));
        System.out.println("777 --> " + isHarshadNumber(777));
        assert (isHarshadNumber(777));
        System.out.println("8316 --> " + isHarshadNumber(8316));
        assert (isHarshadNumber(8316));
        System.out.println("9214 --> " + isHarshadNumber(9214));
        assert (!isHarshadNumber(9214));
        System.out.println("172986 --> " + isHarshadNumber(172986));
        assert (isHarshadNumber(172986));
        //**********************************************************************

        //TODO: Testen Sie hier alle Methoden mit verschiedenen Inputs!
        printHarshadNumbersInInterval(51,79);
    }
}
