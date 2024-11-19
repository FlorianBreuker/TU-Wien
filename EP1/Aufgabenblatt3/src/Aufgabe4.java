/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static boolean isStartAndEndSeq(String text, String sequence) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (sequence.length() * 2 > text.length()) {
            return false;
        }
        if (!sequence.isEmpty()) {
            if (
                // checks if first character of text is equal to the first character of the sequence
                    text.charAt(0) == sequence.charAt(0) &&
                            //checks if, last character of text is equal to last character of sequence
                            text.charAt(text.length() - 1) == sequence.charAt(sequence.length() - 1)
                            // if the text is starting with sequence,
                            // the last character of the sequence should match with the last character of the starting sequence
                            && text.charAt(sequence.length() - 1) == sequence.charAt(sequence.length() - 1)
                            // if the text is ending with sequence,
                            // the first character of the sequence should match with the last character of the ending sequence
                            && text.charAt(text.length() - sequence.length()) == sequence.charAt(0)
            ) {
                if (sequence.length() == 1) {
                    return true;
                }
                // cuts first and last character until text is empty
                return isStartAndEndSeq(text.substring(1, text.length() - 1), sequence.substring(1, sequence.length() - 1));
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static void main(String[] args) {

        System.out.println(isStartAndEndSeq("", "1"));
        System.out.println(isStartAndEndSeq("AA", "A"));
        System.out.println(isStartAndEndSeq("ABBAB", "AB"));
        System.out.println(isStartAndEndSeq("ABBBA", "AB"));
        System.out.println(isStartAndEndSeq("ottootto", "otto"));

        System.out.println(isStartAndEndSeq("otto", "otto"));
        System.out.println(isStartAndEndSeq("ottotto", "otto"));
        System.out.println(isStartAndEndSeq("ottoottt", "otto"));
        System.out.println(isStartAndEndSeq("test1234test", "test"));
        System.out.println(isStartAndEndSeq("NEN", "NEEN"));

        //DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE.
        //**********************************************************************
        assert (isStartAndEndSeq("", "1") == false);
        assert (isStartAndEndSeq("AA", "A") == true);
        assert (isStartAndEndSeq("ABBAB", "AB") == true);
        assert (isStartAndEndSeq("ABBBA", "AB") == false);
        assert (isStartAndEndSeq("ottootto", "otto") == true);
        assert (isStartAndEndSeq("otto", "otto") == false);
        assert (isStartAndEndSeq("ottotto", "otto") == false);
        assert (isStartAndEndSeq("ottoottt", "otto") == false);
        assert (isStartAndEndSeq("test1234test", "test") == true);
        assert (isStartAndEndSeq("NEN", "NEEN") == false);
        //**********************************************************************
    }
}
