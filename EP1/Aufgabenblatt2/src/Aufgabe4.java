/*
    Aufgabe 4) Password - Entropieberechnung
*/

import java.util.Random;

public class Aufgabe4 {

    public static void main(String[] args) {

        int passwordLength = 20;
        String characterSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int seed = 0;
        Random myRand = new Random(seed);

        String password = "";

        //TODO: Implementieren Sie hier die Aufgabe
        for (int i = 0; i < passwordLength; i++) {
            int characterPosition = myRand.nextInt(characterSet.length());
            password += characterSet.charAt(characterPosition);
        }

        double entropy = calculateEntropy(password);
        String securityLevel;

        if (entropy < 60) {
            securityLevel = "weak";
        } else if (entropy >= 60 && entropy < 120) {
            securityLevel = "strong";
        } else {
            securityLevel = "very strong";
        }

        System.out.println("The generated password is: " + password);
        System.out.println("Entropy of the password: " + entropy + " -> The password is:" + securityLevel);

    }

    private static double calculateEntropy(String password) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        boolean containsLowerCase = false;
        boolean containsUpperCase = false;
        boolean containsNumber = false;

        double alphabetLength = 0;

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            if (Character.isLowerCase(character)) {
                containsLowerCase = true;
            } else if (Character.isUpperCase(character)) {
                containsUpperCase = true;
            } else if (Character.isDigit(character)) {
                containsNumber = true;
            }
        }

        if (containsLowerCase && containsNumber && containsUpperCase) {
            alphabetLength = 62;
        } else if (!containsNumber && containsUpperCase && containsLowerCase) {
            alphabetLength = 52;
        } else if ((containsNumber && containsUpperCase) || (containsNumber && containsLowerCase)) {
            alphabetLength = 36;
        } else if ((!containsNumber && containsUpperCase & !containsLowerCase || !containsNumber && containsLowerCase && !containsUpperCase)) {
            alphabetLength = 26;
        } else {
            alphabetLength = 10;
        }

        return password.length() * (Math.log10(alphabetLength) / Math.log10(2.0));
    }
}
