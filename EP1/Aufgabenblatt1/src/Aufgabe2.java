/*
    Aufgabe 2) while-Schleifen
*/
public class Aufgabe2 {

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        String text = "Eine nennenswerte und geeignete Sprache.";
        String testText = "Anzahl der Zeichen ist nicht genug!";
        String vowelTrigger = "aeiouAEIOU";

        text = testText;

        //A
        int whileCounterA = 0;
        while (whileCounterA < text.length()) {
            char currentChar = text.charAt(whileCounterA);
            //checks if currentChar is a vowel
            if (vowelTrigger.indexOf(currentChar) != -1) {
                //adds a "-" before the currentChar
                System.out.print("-" + currentChar);
            } else {
                System.out.print(currentChar);
            }
            whileCounterA++;
        }
        System.out.println();

        //B
        int whileCounterB = 0;
        String letterTrigger = "abcdefghijABCDEFGHIJ ";
        String resultB = "";

        while (whileCounterB < text.length()) {
            char currentChar = text.charAt(whileCounterB);
            //adds every char as a String to the result, if it's not part of the trigger
            if (letterTrigger.indexOf(currentChar) == -1) {
                resultB += "" + currentChar;
            }
            whileCounterB++;
        }
        System.out.println(resultB);

        //C
        int startNumber = 35;
        int endNumber = 175;

        int counterC = startNumber;
        //iterates through all numbers between start an end (incl. start, excl. end)
        while (counterC < endNumber) {
            //checks if the current number is evenly divisible by 5 and 7
            if (counterC % 5 == 0 && counterC % 7 == 0) {
                System.out.print(counterC + " ");
            }
            counterC++;
        }
    }
}






