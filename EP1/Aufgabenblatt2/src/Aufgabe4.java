/*
    Aufgabe 4) Password - Entropieberechnung
*/

import java.util.Random;

public class Aufgabe4 {

    public static void main(String[] args) {

        int passwordLength = 30;
        String characterSet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int seed = 0;
        Random myRand = new Random(seed);

        String password = "";

        //TODO: Implementieren Sie hier die Aufgabe
        //iterates till a password with the length of passwordLength is generated
        for (int i = 0; i < passwordLength; i++) {
            //picks a random index inside characterSet
            int characterPosition = myRand.nextInt(characterSet.length());
            //adds the generated character to the password
            password += characterSet.charAt(characterPosition);
        }

        double entropy = calculateEntropy(password);
        String securityLevel;
        //checks the security level based on the entropy
        if (entropy < 60) {
            securityLevel = "weak";
        } else if (entropy >= 60 && entropy < 120) {
            securityLevel = "strong";
        } else {
            securityLevel = "very strong";
        }
        System.out.println("The generated password is: " + password);
        System.out.println("Entropy of the password: " + entropy + " -> The password is: " + securityLevel);
    }

    private static double calculateEntropy(String password) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        boolean containsLowerCase = false;
        boolean containsUpperCase = false;
        boolean containsNumber = false;
        double alphabetLength;
        //iterates through password
        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            // checks the occurrence of numbers, upper and lower cases
            if (Character.isLowerCase(character)) {
                containsLowerCase = true;
            } else if (Character.isUpperCase(character)) {
                containsUpperCase = true;
            } else if (Character.isDigit(character)) {
                containsNumber = true;
            }
        }
        //checks the length of the alphabet based on the occurring character types
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
        //returns the result of the give formula
        return password.length() * (Math.log10(alphabetLength) / Math.log10(2.0));
    }
}
