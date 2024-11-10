/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static boolean isStartAndEndSeq(String text, String sequence) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (text.isEmpty()) {
            return false;
        } else {
            if (text.length() == sequence.length()) {
                if (text.equals(sequence)) {
                    return true;
                }
            }
            String temp = text.substring(1);
            return isStartAndEndSeq(temp,sequence);
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
