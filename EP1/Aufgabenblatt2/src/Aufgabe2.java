import org.w3c.dom.ls.LSOutput;

/*
    Aufgabe 2) Erste Methoden
*/
public class Aufgabe2 {

    //TODO: Implementieren Sie hier die in der Angabe beschriebenen Methoden

    public static void main(String[] args) {
        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODEN.
        //ENTFERNEN SIE DIE KOMMENTARE, UM IHRE METHODEN ZU TESTEN.
        printNumCharsInString("Hello my name is Flo", 0, 21);

        printNumbersInInterval(0,100);

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
        //iterates as long as numChar is reached
        while (numChar > 0) {
            if (currentIndex == text.length()) {
                //sets the index to 0 in case the last character is reached
                currentIndex = 0;
            }
            //outputs the character of text at position currentIndex
            System.out.print(text.charAt(currentIndex));
            currentIndex++;
            numChar--;
        }
        System.out.println();
    }

    private static void printNumbersInInterval (int start, int end) {
        //iterates from end to start
        for (int i = end; i >= start ; i--) {
            if (i % 3 == 0){
                //prints the number in case it's evenly dividable by 3
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static boolean isCharNTimesInString(String text, char character, int nTimes){
        int counter = 0;
        //iterates through text and counts the appearance of character
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == character) {
                counter++;
            }
        }
        //returns true, if the nTimes matches the counted value
        return nTimes == counter;
    }

    private static String changeLettersInString(String text){
        String trigger = "bcdefghijklmnopqrstuvwxyz";
        String result = "";
        //iterates through the text
        for (int i = 0; i < text.length(); i++) {
            //gets the ASCII value of the new character after a left shift (ASCII - 1)
            char newChar = (char) (text.charAt(i) - 1);
            if(trigger.indexOf(text.toLowerCase().charAt(i)) != -1){
                //prints the newChar if, its base form is contained in the trigger
                result += newChar;
            } else {
                result += text.charAt(i);
            }
        }
        return result;
    }
}
