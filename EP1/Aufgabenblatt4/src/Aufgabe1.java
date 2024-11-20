/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void printArray(int[] workArray) {
        for (int i = workArray.length - 1; i >= 0; i--) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    private static void fillArray(int[] filledArray) {
        int number = 3;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 3;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 9 == 0) {
                copiedArray[i] = -1;
            }
        }
        //printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[15];
        int number = 4;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 4;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    public static void main(String[] args) {
        int[] filledArray = new int[15];
        int[] equalTestArray1 = new int[15];
        int[] equalTestArray2 = new int[15];
        fillArray(filledArray);
        fillArray(equalTestArray1);
        fillArray(equalTestArray2);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 123;
        printArray(filledArray);
        char test = (char) 0; //Zusatzfrage 2
        System.out.println(filledArray[test]);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);

        System.out.println(equalTestArray1 == equalTestArray2);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Antwort zu Punkt a:
    // Wenn man i den Wert der Länge vom Array übergibt muss darauf geachtet werden, dass ein Array bei index=0 anfängt
    // zu zählen. Somit zeigt Array[15] ins leere und es kommt zu einem out of bounds error
    //Antwort zu Punkt b:
    // Die Funktion ist void, also wir auch nichts zurück gegeben, aufgrund der Referenzen wird das Array trotzdem
    // befüllt.
    //Antwort zu Punkt c:
    // Da wir mit Referenzen arbeiten, zeigt auch copiedArray auf den Speicher von filledArray
    // Aus diesem Grund werden dort auch die Werte in "filledArray" manipuliert.
    //Antwort zu Punkt d:
    // Innerhalb vom Kontext der Funktion referenziert "workArray" auf das "helpArray".
    // Aus diesem Grund werden auch die Werte von "helpArray" ausgegeben.
    // In der Methode "main" kommt diese Referenz jedoch nie an, weil "helpArray" nur in "fillArrayWithNewContent" existiert.
    // Im Kontext von "main" referenziert "filledArray" nun wieder auf das Ausgangsarray.

    // Zusatzfragen:
    // 1)
    // Einen ganzzahligen Wert (byte, short, int) und char
    // 2)
    // Gar nicht, damit die Länge verändert werden kann muss ein neues Array mit neuer Länge erstellt werden.
    // 3)
    // Ich würde die <array>.clone()-Methode verwenden
    // 4)
    // Da das Objekt Array eigentlich nur eine Referenz speichert, vergleicht man eigentlich nur diese.
    // Es macht also keinen Sinn zwei Arrays mittels "==" zu vergleichen, um die Werte zu vergleichen.
}
