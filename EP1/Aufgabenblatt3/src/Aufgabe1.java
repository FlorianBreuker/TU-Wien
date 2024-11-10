/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {
    //TODO zu Punkt a): Beschreiben Sie hier in 1-2 Sätzen was der Spaghetticode macht
    // Der Spaghetticode zeichnet eine symmetrische Figur in die Konsole.
    // Mit Schleifen wird die Form nach und nach aufgebaut.

    //TODO zu Punkt b): Beschreiben Sie in 1-2 Sätzen was Sie ändern würden und warum
    // Ich würde den Spaghetticode in Methoden untergliedern, da damit die Lesbarkeit gefördert wird.
    // Zudem würde ich versuchen redundaten Code zu entfernen und gehardcodete Zeilen durch Schleifen generieren


    //TODO zu Punkt c und d): Implementieren Sie hier die Methoden Ihrer Lösung

    private static void drawFigure(int width) {
        int height = width++;
        drawFirstAndLastRow(width);
        drawFirstHalf(width);
        drawSymmetricAxis(width);
        drawSecondHalf(width);
        drawFirstAndLastRow(width);
    }

    private static void drawFirstAndLastRow(int width) {
        // draws first and last row of the figure based on the width
        for (int i = 1; i < width; i++) {
            // checks if it's the first or last column of the row
            if (i == 1 || i == width - 1) {
                System.out.print("#");
            } else {
                System.out.print("+");
            }
        }
        System.out.println();
    }

    private static void drawFirstHalf(int width) {
        // draws the rows from start row to the symmetric axis
        for (int i = 1; i < width / 2; i++) {
            System.out.print("#");
            drawDotsFirstHalf(i, width);
            System.out.print("/");
            drawSpacesFirstHalf(i);
            System.out.print("\\");
            drawDotsFirstHalf(i, width);
            System.out.print("#");
            System.out.println();
        }
    }

    private static void drawDotsFirstHalf(int i, int width) {
        for (int j = 1; j <= ((width - 2) / 2 - i); j++) {
            // draws the dots after "\"
            System.out.print(".");
        }
    }

    private static void drawSpacesFirstHalf(int i) {
        // draws the spaces in between "/" and "\"
        for (int j = 1; j <= 2 * (i - 1); j++) {
            System.out.print(" ");
        }
    }

    private static void drawSymmetricAxis(int width) {
        for (int i = 1; i < width; i++) {
            if (i == 1 || i == width - 1) {
                // checks for first and last column
                System.out.print("#");
            } else if (i == 2 || i == width - 2) {
                // checks for 2nd and penultimate column
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    private static void drawSecondHalf(int width) {
        // draws the rows from symmetric axis to the end
        for (int i = 1; i < width / 2; i++) {
            System.out.print("#");
            drawDotsSecondHalf(i);
            System.out.print("\\");
            drawSpacesSecondHalf(i, width);
            System.out.print("/");
            drawDotsSecondHalf(i);
            System.out.print("#");
            System.out.println();
        }
    }

    private static void drawDotsSecondHalf(int i) {
        for (int j = 2; j <= i; j++) {
            // draws the dots before "\"
            System.out.print(".");
        }
    }

    private static void drawSpacesSecondHalf(int i, int width) {
        for (int j = 1; j <= ((width - 2) - 2 * i - 1); j++) {
            // draws the spaces in between "\" and "/"
            System.out.print(" ");
        }
    }

    public static void main(String args[]) {
        //********************************************************
        //TODO zu Punkt c,d und e): Implementieren Sie hier Ihre Lösung für die Angabe

        int width = 10;
        System.out.println("Ihre Ausgabe:");

        drawFigure(width);

        //********************************************************

        System.out.println();
        System.out.println("Ausgabe Spaghetticode:");
        drawSpaghetti();
    }

    private static void drawSpaghetti() {
        System.out.print("#");
        for (int i = 1; i <= 8; i++) {
            System.out.print("+");
        }
        System.out.println("#");

        for (int i = 1; i < 5; i++) {
            System.out.print("#");
            for (int j = 2; j <= (8 / 2 - i + 1); j++) {
                System.out.print(".");
            }
            System.out.print("/");
            for (int j = 1; j <= 2 * (i - 1); j++) {
                System.out.print(" ");
            }
            System.out.print("\\");
            for (int j = 2; j <= (8 / 2 - i + 1); j++) {
                System.out.print(".");
            }
            System.out.print("#");
            System.out.println();
        }

        System.out.println("#|      |#");
        for (int i = 1; i < 5; i++) {
            System.out.print("#");
            for (int j = 2; j <= i; j++) {
                System.out.print(".");
            }
            System.out.print("\\");
            for (int j = 1; j <= (8 - 2 * i); j++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int j = 2; j <= i; j++) {
                System.out.print(".");
            }
            System.out.print("#");
            System.out.println();
        }

        System.out.print("#");
        for (int i = 1; i <= 8; i++) {
            System.out.print("+");
        }
        System.out.println("#");
    }
}


