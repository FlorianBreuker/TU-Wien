// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "n sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'n.peek()' die Zahl 7 als Ergebnis?",

                        new Choice(false, "n.push(7); n.push(2); n.push(n.pop());                                        (1A)"),
                        new Choice(false, "n.push(7); n.push(2); n.push(n.peek());                                       (1B)"),
                        new Choice(true, "n.push(2); n.push(1); n.push(7);                                              (1C)"),
                        new Choice(true, "n.push(2); n.push(n.pop()); n.push(7);                                        (1D)"),
                        new Choice(false, "n.push(7); n.push(n.peek()); n.push(2);                                       (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf die unterschiedlichen Arten\n" +
                        "linearer und assoziativer Datenstrukturen?",

                        new Choice(false, "Wahlfreie Zugriffe auf lineare Datenstrukturen sind sehr effizient.           (2A)"),
                        new Choice(false, "Assoziative Datenstrukturen haben FIFO-Verhalten.                             (2B)"),
                        new Choice(false, "Assoziative Datenstrukturen erlauben keine wahlfreien Zugriffe.               (2C)"),
                        new Choice(true, "Assoziative Datenstrukturen können bei Bedarf größer werden.                  (2D)"),
                        new Choice(false, "'put(k,v)' gibt den alten Wert zurück wenn k schon existiert.                 (2E)")
                ),

                new Question(
                        "K, U und Q seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?",

                        new Choice(false, "Ist K ein Interface, dann ist K Untertyp von java.lang.Object.                (3A)"),
                        new Choice(false, "Aus 'K Untertyp von Q' und 'Q Untertyp von U' folgt: 'K Untertyp von U'.      (3B)"),
                        new Choice(false, "'null' ist ein Objekt von jedem Referenztyp Q.                                (3C)"),
                        new Choice(true, "Q ist Untertyp von Q.                                                         (3D)"),
                        new Choice(true, "Aus 'U Untertyp von Q' und 'Q Untertyp von U' folgt: 'U.class==Q.class'.      (3E)")
                ),

                new Question(
                        "u sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'u.peekFirst()'\n" +
                        "die Zahl 4 als Ergebnis?",

                        new Choice(true, "u.addFirst(5); u.addLast(0); u.addFirst(4);                                   (4A)"),
                        new Choice(false, "u.addFirst(4); u.addFirst(0); u.pollLast();                                   (4B)"),
                        new Choice(false, "u.addFirst(4); u.addFirst(0);                                                 (4C)"),
                        new Choice(true, "u.addFirst(4); u.addFirst(0); u.addFirst(u.peekLast());                       (4D)"),
                        new Choice(true, "u.addFirst(4); u.addFirst(0); u.pollFirst();                                  (4E)")
                ),

                new Question(
                        "N sei ein Referenztyp (Klasse oder Interface), und v sei eine durch\n" +
                        "'V v = new D();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden N, V, D und v zu?",

                        new Choice(false, "'(N)null' liefert einen Laufzeitfehler.                                       (5A)"),
                        new Choice(false, "'(N)v' liefert einen Laufzeitfehler wenn V Untertyp von N ist.                (5B)"),
                        new Choice(false, "'(N)v' liefert Laufzeitfehler wenn N nicht Untertyp von V ist.                (5C)"),
                        new Choice(false, "Mit 'D ist Untertyp von N' gilt: '((N)v).getClass() == D.class'               (5D)"),
                        new Choice(true, "'(N)v' ändert den deklarierten Typ von v auf N.                               (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. n sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'n.peek()' die Zahl 7 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX n.push(7); n.push(2); n.push(n.pop());                                        (1A)\n" +
            "    XXXXXXXXX n.push(7); n.push(2); n.push(n.peek());                                       (1B)\n" +
            "    XXXXXXXXX n.push(2); n.push(1); n.push(7);                                              (1C)\n" +
            "    XXXXXXXXX n.push(2); n.push(n.pop()); n.push(7);                                        (1D)\n" +
            "    XXXXXXXXX n.push(7); n.push(n.peek()); n.push(2);                                       (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen stimmen in Bezug auf die unterschiedlichen Arten\n" +
            "    linearer und assoziativer Datenstrukturen?\n" +
            "    \n" +
            "    XXXXXXXXX Wahlfreie Zugriffe auf lineare Datenstrukturen sind sehr effizient.           (2A)\n" +
            "    XXXXXXXXX Assoziative Datenstrukturen haben FIFO-Verhalten.                             (2B)\n" +
            "    XXXXXXXXX Assoziative Datenstrukturen erlauben keine wahlfreien Zugriffe.               (2C)\n" +
            "    XXXXXXXXX Assoziative Datenstrukturen können bei Bedarf größer werden.                  (2D)\n" +
            "    XXXXXXXXX 'put(k,v)' gibt den alten Wert zurück wenn k schon existiert.                 (2E)\n" +
            "\n" +
            " 3. K, U und Q seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Ist K ein Interface, dann ist K Untertyp von java.lang.Object.                (3A)\n" +
            "    XXXXXXXXX Aus 'K Untertyp von Q' und 'Q Untertyp von U' folgt: 'K Untertyp von U'.      (3B)\n" +
            "    XXXXXXXXX 'null' ist ein Objekt von jedem Referenztyp Q.                                (3C)\n" +
            "    XXXXXXXXX Q ist Untertyp von Q.                                                         (3D)\n" +
            "    XXXXXXXXX Aus 'U Untertyp von Q' und 'Q Untertyp von U' folgt: 'U.class==Q.class'.      (3E)\n" +
            "\n" +
            " 4. u sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'u.peekFirst()'\n" +
            "    die Zahl 4 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX u.addFirst(5); u.addLast(0); u.addFirst(4);                                   (4A)\n" +
            "    XXXXXXXXX u.addFirst(4); u.addFirst(0); u.pollLast();                                   (4B)\n" +
            "    XXXXXXXXX u.addFirst(4); u.addFirst(0);                                                 (4C)\n" +
            "    XXXXXXXXX u.addFirst(4); u.addFirst(0); u.addFirst(u.peekLast());                       (4D)\n" +
            "    XXXXXXXXX u.addFirst(4); u.addFirst(0); u.pollFirst();                                  (4E)\n" +
            "\n" +
            " 5. N sei ein Referenztyp (Klasse oder Interface), und v sei eine durch\n" +
            "    'V v = new D();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden N, V, D und v zu?\n" +
            "    \n" +
            "    XXXXXXXXX '(N)null' liefert einen Laufzeitfehler.                                       (5A)\n" +
            "    XXXXXXXXX '(N)v' liefert einen Laufzeitfehler wenn V Untertyp von N ist.                (5B)\n" +
            "    XXXXXXXXX '(N)v' liefert Laufzeitfehler wenn N nicht Untertyp von V ist.                (5C)\n" +
            "    XXXXXXXXX Mit 'D ist Untertyp von N' gilt: '((N)v).getClass() == D.class'               (5D)\n" +
            "    XXXXXXXXX '(N)v' ändert den deklarierten Typ von v auf N.                               (5E)\n" +
            "\n";

    public static final long UID = 251649157297650L;

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