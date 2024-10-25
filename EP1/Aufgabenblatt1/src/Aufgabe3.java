/*
    Aufgabe 3) Simulation mit verschachtelten Schleifen
*/

public class Aufgabe3 {

    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        double maxCap = 1500;
        double numFoxes = 2;
        double numRabbits = 2500;
        int dt = 1;

        int iterations = 500;

        for (int i = 1; i < iterations + 1; i++) {
            double freeCap = maxCap - numRabbits;
            double incRabbits = (1.0 / maxCap) * freeCap * 0.08 * numRabbits;
            double decFoxes = 0.2 * numFoxes;
            double numContacts = numRabbits * numFoxes;

            numRabbits = numRabbits + dt * (incRabbits - 0.002 * numContacts);
            numFoxes = numFoxes + dt * (0.0004 * numContacts - decFoxes);

            char foxSymbol = '#';
            char rabbitSymbol = '*';
            String foxGraph = "";
            String rabbitGraph = "";

            //calculates the number of # and * based on the factor provided in the text
            int numberOfFoxSymbols = (int) Math.round(numFoxes / 2 * 5);
            int numberOfRabbitSymbols = (int) Math.round(numRabbits / 5);

            //adds the amount of symbols to the graph string
            for (int j = 0; j < numberOfFoxSymbols; j++) {
                foxGraph += foxSymbol;
            }
            for (int j = 0; j < numberOfRabbitSymbols; j++) {
                rabbitGraph += rabbitSymbol;
            }

            // formats the output
            System.out.format("Iteration: %d" + " freeCAP: %.2f" + " numRabbits: %.2f" + " numFoxes: %.2f", i, freeCap, numRabbits, numFoxes);
            System.out.println();
            System.out.println(rabbitGraph);
            System.out.println(foxGraph);
            System.out.println();

        }
    }
}
