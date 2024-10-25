/*
    Aufgabe 1) for-Schleifen
*/
public class Aufgabe1 {

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        //A
        int resultA = 0;
        for (int i = 21; i < 420; i++) {
            //checks if the number is evenly divisible by 21
            if (i % 21 == 0) {
                resultA += i; //sums up all those numbers
            }
        }
        System.out.println(resultA);

        //B
        String resultB = ":";
        for (int i = 45; i <= 135; i++) {
            //checks if the current number is evenly divisible by 5 but not by 9
            if (i % 5 == 0 && i % 9 != 0) {
                //adds the number incl. ":" to the output string
                resultB += i + ":";
            }
        }
        System.out.println(resultB);

        //C
        String resultC = "";
        for (int i = 70; i > 50; i--) {
            //all ASCII chars, but the last element
            if (i > 51) {
                resultC += (char) i + ",";
                //the last element doesn't get a comma
            } else {
                resultC += (char) i;
            }

        }
        System.out.println(resultC);

        //D
        String sentence = "Zehn zahme Ziegen zogen ziemlich zügig zehn Zentner Zucker zum Zoo!";
        int zZCounter = 0;
        String trigger = "zZ";

        for (int i = 0; i < sentence.length(); i++) {
            //checks if the current char is part of the trigger string
            if (trigger.indexOf(sentence.charAt(i)) != -1) {
                zZCounter++;
            }
        }
        System.out.println(zZCounter);
    }
}
