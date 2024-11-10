/*
    Aufgabe 5) Rekursion
*/
public class Aufgabe5 {

    private static String orderCharGroups(String text) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Methode
        String result = "";
        if (text.isEmpty()){
            return text;
        }
        if (text.charAt(0) == text.charAt(text.length()-1)){
            result = orderCharGroups(text.substring(1)) + text.charAt(0);
        } else {
            result = text.charAt(0) + orderCharGroups(text.substring(1));
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(orderCharGroups(""));
        System.out.println(orderCharGroups("1"));
        System.out.println(orderCharGroups("12"));
        System.out.println(orderCharGroups("1212"));
        System.out.println(orderCharGroups("abbaaababbaa"));
        System.out.println(orderCharGroups("ABBA"));
        System.out.println(orderCharGroups("11221122"));
        System.out.println(orderCharGroups("AAAAAA"));
        System.out.println();

    }
}
