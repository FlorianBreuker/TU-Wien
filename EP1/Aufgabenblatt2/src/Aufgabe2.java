import org.w3c.dom.ls.LSOutput;

/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    //TODO: Implementieren Sie hier die in der Angabe beschriebenen Methoden

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.
        printNumbersInInterval(0,100);
        printNumCharsInString("Hello my name is Flo", 0, 100);
        assert (isCharNTimesInString("nennenswerte Worte", 'n', 4));
        assert (!isCharNTimesInString("nennenswerte Worte", 'n', 3));
        assert (!isCharNTimesInString("nennenswerte Worte", 'e', 6));
        assert (isCharNTimesInString("Test", 'x', 0));

        assert (changeLettersInString("Hello World!").equals("Gdkkn Vnqkc!"));
        assert (changeLettersInString("Anfang und Ende.").equals("Ameamf tmc Dmcd."));
        assert (changeLettersInString("+ABC_123_DEF#").equals("+AAB_123_CDE#"));
        assert (changeLettersInString("ABCDYZ_abcdyz").equals("AABCXY_aabcxy"));

        //**********************************************************************

        //TODO: Testen Sie hier zusätzlich alle Methoden mit verschiedenen Inputs!
    }

    private static void printNumCharsInString(String text, int startIndex, int numChar) {
        int currentIndex = startIndex;

        while (numChar > 0) {
            if (currentIndex == text.length()) {
                currentIndex = 0;
            }
            System.out.print(text.charAt(currentIndex));
            currentIndex++;
            numChar--;
        }
    }

    private static void printNumbersInInterval (int start, int end) {
        for (int i = end; i >= start ; i--) {
            if (i % 3 == 0){
                System.out.print(i + " ");
            }
        }
    }

    private static boolean isCharNTimesInString(String text, char character, int nTimes){
        int counter = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == character) {
                counter++;
            }
        }
        return nTimes == counter;
    }

    private static String changeLettersInString(String text){
        String trigger = "bcdefghijklmnopqrstuvwxyz";
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.toLowerCase().charAt(i);
            char newChar = (char) (text.charAt(i) - 1);
            if(trigger.indexOf(currentChar) != -1){
                result += newChar;
            } else {
                result += text.charAt(i);
            }
        }
        return result;
    }
}
