// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf die Einhaltung von Zusicherungen\n" +
                        "entsprechend Design-by-Contract zu?",

                        new Choice(false, "Aufrufer müssen für die Einhaltung von Nachbedingungen sorgen.                     (1A)"),
                        new Choice(false, "Aufrufer können sich auf die Einhaltung von Nachbedingungen verlassen.             (1B)"),
                        new Choice(false, "Aufrufer müssen für die Einhaltung von Vorbedingungen sorgen.                      (1C)"),
                        new Choice(false, "Vor Methodenaufrufen müssen alle Invarianten erfüllt sein.                         (1D)"),
                        new Choice(false, "Aufrufer können sich auf die Einhaltung der Vorbedingungen verlassen.              (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?",

                        new Choice(false, "'new FileWriter(s)' wirft keine IOException wenn s schon existiert.                (2A)"),
                        new Choice(false, "'new FileReader(s)' erzeugt einen gepufferten Stream.                              (2B)"),
                        new Choice(false, "Puffer können als Wrapper vor ungepufferte Streams gehängt werden.                 (2C)"),
                        new Choice(false, "Ungepufferte Streams sind meist effizienter als gepufferte.                        (2D)"),
                        new Choice(false, "Die meisten Methoden von Writer werfen keine IOException.                          (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?",

                        new Choice(false, "Fehlerfreiheit wird nur durch intensives Testen garantiert.                        (3A)"),
                        new Choice(false, "Anwender können beim Auffinden von Fehlerursachen hilfreich sein.                  (3B)"),
                        new Choice(false, "Grey-Box-Testen legt Testfälle nach der Implementierung fest.                      (3C)"),
                        new Choice(false, "White-Box-Testen leitet Testfälle aus der Implementierung ab.                      (3D)"),
                        new Choice(false, "Regressions-Tests sind fast immer automatisiert.                                   (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?",

                        new Choice(false, "Hash-Tabellen werden wegen ihrer Effizienz häufig eingesetzt.                      (4A)"),
                        new Choice(false, "Bäume verwenden wir meist nur wo andere Datenstrukturen nicht passen.              (4B)"),
                        new Choice(false, "Quicksort eignet sich besser für lineare Listen als für Arrays.                    (4C)"),
                        new Choice(false, "Lineare Listen sind einfach zu implementieren.                                     (4D)"),
                        new Choice(false, "Bei unbekannter Datenverteilung dürfen wir keine Zufallsverteilung annehmen.       (4E)")
                ),

                new Question(
                        "public int sumFrom1To(int k) { return (k * (k + 1)) / 2; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Vorbedingung: Gibt (k * k + k) / 2 zurück.                                         (5A)"),
                        new Choice(false, "Nachbedingung: Ergebnis ist für k < 1 nicht die Zahlensumme.                       (5B)"),
                        new Choice(false, "Nachbedingung: Halbiert (k * (k + 1)).                                             (5C)"),
                        new Choice(false, "Vorbedingung: Ergebnis hängt nur von k ab.                                         (5D)"),
                        new Choice(false, "Vorbedingung: k > 0.                                                               (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf die Einhaltung von Zusicherungen\n" +
            "    entsprechend Design-by-Contract zu?\n" +
            "    \n" +
            "    XXXXXXXXX Aufrufer müssen für die Einhaltung von Nachbedingungen sorgen.                     (1A)\n" +
            "    XXXXXXXXX Aufrufer können sich auf die Einhaltung von Nachbedingungen verlassen.             (1B)\n" +
            "    XXXXXXXXX Aufrufer müssen für die Einhaltung von Vorbedingungen sorgen.                      (1C)\n" +
            "    XXXXXXXXX Vor Methodenaufrufen müssen alle Invarianten erfüllt sein.                         (1D)\n" +
            "    XXXXXXXXX Aufrufer können sich auf die Einhaltung der Vorbedingungen verlassen.              (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX 'new FileWriter(s)' wirft keine IOException wenn s schon existiert.                (2A)\n" +
            "    XXXXXXXXX 'new FileReader(s)' erzeugt einen gepufferten Stream.                              (2B)\n" +
            "    XXXXXXXXX Puffer können als Wrapper vor ungepufferte Streams gehängt werden.                 (2C)\n" +
            "    XXXXXXXXX Ungepufferte Streams sind meist effizienter als gepufferte.                        (2D)\n" +
            "    XXXXXXXXX Die meisten Methoden von Writer werfen keine IOException.                          (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?\n" +
            "    \n" +
            "    XXXXXXXXX Fehlerfreiheit wird nur durch intensives Testen garantiert.                        (3A)\n" +
            "    XXXXXXXXX Anwender können beim Auffinden von Fehlerursachen hilfreich sein.                  (3B)\n" +
            "    XXXXXXXXX Grey-Box-Testen legt Testfälle nach der Implementierung fest.                      (3C)\n" +
            "    XXXXXXXXX White-Box-Testen leitet Testfälle aus der Implementierung ab.                      (3D)\n" +
            "    XXXXXXXXX Regressions-Tests sind fast immer automatisiert.                                   (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen in Bezug auf Algorithmen und Datenstrukturen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Hash-Tabellen werden wegen ihrer Effizienz häufig eingesetzt.                      (4A)\n" +
            "    XXXXXXXXX Bäume verwenden wir meist nur wo andere Datenstrukturen nicht passen.              (4B)\n" +
            "    XXXXXXXXX Quicksort eignet sich besser für lineare Listen als für Arrays.                    (4C)\n" +
            "    XXXXXXXXX Lineare Listen sind einfach zu implementieren.                                     (4D)\n" +
            "    XXXXXXXXX Bei unbekannter Datenverteilung dürfen wir keine Zufallsverteilung annehmen.       (4E)\n" +
            "\n" +
            " 5. public int sumFrom1To(int k) { return (k * (k + 1)) / 2; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingung: Gibt (k * k + k) / 2 zurück.                                         (5A)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis ist für k < 1 nicht die Zahlensumme.                       (5B)\n" +
            "    XXXXXXXXX Nachbedingung: Halbiert (k * (k + 1)).                                             (5C)\n" +
            "    XXXXXXXXX Vorbedingung: Ergebnis hängt nur von k ab.                                         (5D)\n" +
            "    XXXXXXXXX Vorbedingung: k > 0.                                                               (5E)\n" +
            "\n";

    public static final long UID = 249308676356250L;

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