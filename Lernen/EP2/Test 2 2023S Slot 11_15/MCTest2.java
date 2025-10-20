// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(true, "{true} j = g > u ? g : u; {j >= u}                                                 (1A)"),
                        new Choice(false, "{j > -35} if (j > -36) j--; {j > -35}                                              (1B)"),
                        new Choice(false, "{g <= -91} while (++j < -36) g--; {g < -91}                                        (1C)"),
                        new Choice(true, "{g <= -91} while (j > -91) j--; {g <= -91}                                         (1D)"),
                        new Choice(true, "{j > -35} if (j < -36) j--; {j > -35}                                              (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?",

                        new Choice(true, "Puffer können als Wrapper vor ungepufferte Streams gehängt werden.                 (2A)"),
                        new Choice(false, "Die meisten Methoden von PrintStream werfen eine IOException.                      (2B)"),
                        new Choice(true, "Gepufferte Streams sind meist effizienter als ungepufferte.                        (2C)"),
                        new Choice(true, "Streams vom Typ Reader wandeln die Kodierung automatisch um.                       (2D)"),
                        new Choice(false, "Streams vom Typ OutputStream wandeln die Kodierung automatisch um.                 (2E)")
                ),

                new Question(
                        "a, b und c seien Objektreferenzen ungleich null.\n" +
                        "Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
                        "boolean equals(Object obj)  und  int hashCode()  in Java gelten?",

                        // gleich heißt hash codes gleich
                        new Choice(true, "Aus  b.equals(c)  folgt  b.hashCode() == c.hashCode().                             (3A)"),
                        // wenn der hash nicht gleich ist, können sie nicht gleich sein
                        new Choice(true, "Aus  b.hashCode() != c.hashCode()  folgt  !b.equals(c).                            (3B)"),
                        // bloß weil sie nicht gleich sind, können die hashcodes trotzdem gleich sein, d.h. falsch
                        new Choice(false, "Aus  !b.equals(c)  folgt  b.hashCode() != c.hashCode().                            (3C)"),
                        new Choice(false, "null.equals(c)  gibt  false  zurück.                                               (3D)"),
                        new Choice(false, "Aus  b.hashCode() == c.hashCode()  folgt  b.equals(c).                             (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?",

                        new Choice(false, "Eine Schleifeninvariante beschreibt, was jede Iteration ändert.                    (4A)"),
                        new Choice(true, "Die Schleifenbedingung kann nicht Teil einer Schleifeninvariante sein.             (4B)"),
                        new Choice(false, "Schleifeninvarianten müssen vor jedem Methodenaufruf erfüllt sein.                 (4C)"),
                        new Choice(true, "Schleifeninvarianten müssen auch vor und nach der Schleife gelten.                 (4D)"),
                        new Choice(false, "Schleifeninvarianten garantieren den Fortschritt jeder Iteration.                  (4E)")
                ),

                new Question(
                        "public int median(int[] e) { return e[e.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Nachbedingung: Setzt voraus, dass e mindestens einen Eintrag hat.                  (5A)"),
                        new Choice(true, "Vorbedingung: e != null                                                            (5B)"),
                        new Choice(false, "Vorbedingung: Gibt einen Eintrag etwa in der Mitte von e zurück.                   (5C)"),
                        new Choice(false, "Nachbedingung: Halbiert die Länge von e.                                           (5D)"),
                        new Choice(true, "Nachbedingung: Wirft eine Exception wenn e == null.                                (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {true} j = g > u ? g : u; {j >= u}                                                 (1A)\n" +
            "    XXXXXXXXX {j > -35} if (j > -36) j--; {j > -35}                                              (1B)\n" +
            "    XXXXXXXXX {g <= -91} while (++j < -36) g--; {g < -91}                                        (1C)\n" +
            "    XXXXXXXXX {g <= -91} while (j > -91) j--; {g <= -91}                                         (1D)\n" +
            "    XXXXXXXXX {j > -35} if (j < -36) j--; {j > -35}                                              (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Puffer können als Wrapper vor ungepufferte Streams gehängt werden.                 (2A)\n" +
            "    XXXXXXXXX Die meisten Methoden von PrintStream werfen eine IOException.                      (2B)\n" +
            "    XXXXXXXXX Gepufferte Streams sind meist effizienter als ungepufferte.                        (2C)\n" +
            "    XXXXXXXXX Streams vom Typ Reader wandeln die Kodierung automatisch um.                       (2D)\n" +
            "    XXXXXXXXX Streams vom Typ OutputStream wandeln die Kodierung automatisch um.                 (2E)\n" +
            "\n" +
            " 3. a, b und c seien Objektreferenzen ungleich null.\n" +
            "    Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
            "    boolean equals(Object obj)  und  int hashCode()  in Java gelten?\n" +
            "    \n" +
            "    XXXXXXXXX Aus  b.equals(c)  folgt  b.hashCode() == c.hashCode().                             (3A)\n" +
            "    XXXXXXXXX Aus  b.hashCode() != c.hashCode()  folgt  !b.equals(c).                            (3B)\n" +
            "    XXXXXXXXX Aus  !b.equals(c)  folgt  b.hashCode() != c.hashCode().                            (3C)\n" +
            "    XXXXXXXXX null.equals(c)  gibt  false  zurück.                                               (3D)\n" +
            "    XXXXXXXXX Aus  b.hashCode() == c.hashCode()  folgt  b.equals(c).                             (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf Schleifen und Schleifeninvarianten zu?\n" +
            "    \n" +
            "    XXXXXXXXX Eine Schleifeninvariante beschreibt, was jede Iteration ändert.                    (4A)\n" +
            "    XXXXXXXXX Die Schleifenbedingung kann nicht Teil einer Schleifeninvariante sein.             (4B)\n" +
            "    XXXXXXXXX Schleifeninvarianten müssen vor jedem Methodenaufruf erfüllt sein.                 (4C)\n" +
            "    XXXXXXXXX Schleifeninvarianten müssen auch vor und nach der Schleife gelten.                 (4D)\n" +
            "    XXXXXXXXX Schleifeninvarianten garantieren den Fortschritt jeder Iteration.                  (4E)\n" +
            "\n" +
            " 5. public int median(int[] e) { return e[e.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingung: Setzt voraus, dass e mindestens einen Eintrag hat.                  (5A)\n" +
            "    XXXXXXXXX Vorbedingung: e != null                                                            (5B)\n" +
            "    XXXXXXXXX Vorbedingung: Gibt einen Eintrag etwa in der Mitte von e zurück.                   (5C)\n" +
            "    XXXXXXXXX Nachbedingung: Halbiert die Länge von e.                                           (5D)\n" +
            "    XXXXXXXXX Nachbedingung: Wirft eine Exception wenn e == null.                                (5E)\n" +
            "\n";

    public static final long UID = 247218674563146L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}