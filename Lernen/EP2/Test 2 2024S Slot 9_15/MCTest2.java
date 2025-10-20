// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen für Design-by-Contract zu?",

                        new Choice(false, "Nachbedingungen beschreiben häufig Zustandsänderungen.                             (1A)"),
                        new Choice(false, "Auch ohne Zusicherungen muss gelten, was allgemein erwartet wird.                  (1B)"),
                        new Choice(false, "Eine Nachbedingung darf im Untertyp stärker sein als im Obertyp.                   (1C)"),
                        new Choice(false, "Nachbedingungen beziehen sich auf alle Methoden der Klasse.                        (1D)"),
                        new Choice(false, "Invarianten beschreiben häufig Eigenschaften von Rückgabewerten.                   (1E)")
                ),

                new Question(
                        "Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?",

                        new Choice(false, "{e > -79} while (e > -79) e--; {e > -79}                                           (2A)"),
                        new Choice(false, "{true} e += 1; {e >= 0}                                                            (2B)"),
                        new Choice(false, "{e > 74} if (e > 73) e--; {e > 74}                                                 (2C)"),
                        new Choice(false, "{e == 73} e += 1; {e == 74}                                                        (2D)"),
                        new Choice(false, "{true} e = -79; {e >= -79}                                                         (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
                        "Java-Collections-Framework zu?",

                        new Choice(false, "Set<E> erweitert Collection<E> um zusätzliche Methoden.                            (3A)"),
                        new Choice(false, "LinkedList<E> ist Untertyp von TreeSet<E>                                          (3B)"),
                        new Choice(false, "In eine Queue<E> kann man neben offer auch mittels add einfügen.                   (3C)"),
                        new Choice(false, "LinkedList<E> erlaubt mehrere gleiche Einträge.                                    (3D)"),
                        new Choice(false, "LinkedHashSet<E> ist eine lineare Liste, die Hashtabellen enthält.                 (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die Qualität großer Programme und\n" +
                        "das zur Erreichung der geforderten Qualität nötige Qualitätsmanagement zu?",

                        new Choice(false, "Formale Korrektheitsbeweise sind für große Programme extrem aufwendig.             (4A)"),
                        new Choice(false, "Pair-Programming gilt als qualitätssteigernde Maßnahme.                            (4B)"),
                        new Choice(false, "Zur Effekivitätssteigerung sind Team-Besprechungen zu vermeiden.                   (4C)"),
                        new Choice(false, "Vertrauen gegenüber Teammitgliedern kann die Qualität verbessern.                  (4D)"),
                        new Choice(false, "Konfigurierbarkeit kann die Brauchbarkeit des Programms verbessern.                (4E)")
                ),

                new Question(
                        "public int median(int[] w) { return w[w.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Nachbedingung: Wirft eine Exception wenn w == null.                                (5A)"),
                        new Choice(false, "Nachbedingung: Setzt voraus, dass w mindestens einen Eintrag hat.                  (5B)"),
                        new Choice(false, "Nachbedingung: w ist aufsteigend sortiert.                                         (5C)"),
                        new Choice(false, "Vorbedingung: w.length > 0                                                         (5D)"),
                        new Choice(false, "Nachbedingung: Gibt einen Eintrag etwa in der Mitte von w zurück.                  (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen für Design-by-Contract zu?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingungen beschreiben häufig Zustandsänderungen.                             (1A)\n" +
            "    XXXXXXXXX Auch ohne Zusicherungen muss gelten, was allgemein erwartet wird.                  (1B)\n" +
            "    XXXXXXXXX Eine Nachbedingung darf im Untertyp stärker sein als im Obertyp.                   (1C)\n" +
            "    XXXXXXXXX Nachbedingungen beziehen sich auf alle Methoden der Klasse.                        (1D)\n" +
            "    XXXXXXXXX Invarianten beschreiben häufig Eigenschaften von Rückgabewerten.                   (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Hoare-Tripel gelten (für Anweisungen in Java)?\n" +
            "    \n" +
            "    XXXXXXXXX {e > -79} while (e > -79) e--; {e > -79}                                           (2A)\n" +
            "    XXXXXXXXX {true} e += 1; {e >= 0}                                                            (2B)\n" +
            "    XXXXXXXXX {e > 74} if (e > 73) e--; {e > 74}                                                 (2C)\n" +
            "    XXXXXXXXX {e == 73} e += 1; {e == 74}                                                        (2D)\n" +
            "    XXXXXXXXX {true} e = -79; {e >= -79}                                                         (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf Klassen und Interfaces im\n" +
            "    Java-Collections-Framework zu?\n" +
            "    \n" +
            "    XXXXXXXXX Set<E> erweitert Collection<E> um zusätzliche Methoden.                            (3A)\n" +
            "    XXXXXXXXX LinkedList<E> ist Untertyp von TreeSet<E>                                          (3B)\n" +
            "    XXXXXXXXX In eine Queue<E> kann man neben offer auch mittels add einfügen.                   (3C)\n" +
            "    XXXXXXXXX LinkedList<E> erlaubt mehrere gleiche Einträge.                                    (3D)\n" +
            "    XXXXXXXXX LinkedHashSet<E> ist eine lineare Liste, die Hashtabellen enthält.                 (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf die Qualität großer Programme und\n" +
            "    das zur Erreichung der geforderten Qualität nötige Qualitätsmanagement zu?\n" +
            "    \n" +
            "    XXXXXXXXX Formale Korrektheitsbeweise sind für große Programme extrem aufwendig.             (4A)\n" +
            "    XXXXXXXXX Pair-Programming gilt als qualitätssteigernde Maßnahme.                            (4B)\n" +
            "    XXXXXXXXX Zur Effekivitätssteigerung sind Team-Besprechungen zu vermeiden.                   (4C)\n" +
            "    XXXXXXXXX Vertrauen gegenüber Teammitgliedern kann die Qualität verbessern.                  (4D)\n" +
            "    XXXXXXXXX Konfigurierbarkeit kann die Brauchbarkeit des Programms verbessern.                (4E)\n" +
            "\n" +
            " 5. public int median(int[] w) { return w[w.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Nachbedingung: Wirft eine Exception wenn w == null.                                (5A)\n" +
            "    XXXXXXXXX Nachbedingung: Setzt voraus, dass w mindestens einen Eintrag hat.                  (5B)\n" +
            "    XXXXXXXXX Nachbedingung: w ist aufsteigend sortiert.                                         (5C)\n" +
            "    XXXXXXXXX Vorbedingung: w.length > 0                                                         (5D)\n" +
            "    XXXXXXXXX Nachbedingung: Gibt einen Eintrag etwa in der Mitte von w zurück.                  (5E)\n" +
            "\n";

    public static final long UID = 249422772759375L;

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