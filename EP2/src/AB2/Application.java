package AB2;

import AB2.Interfaces.LineBuffer;

/**
 * The Application class serves as the entry point to the program.
 * <p>This class is used to test and demonstrate the functionality of printing text in Braille format
 * using the AdvancedLinePrinter, configured with a BrailleLineBuffer, a BrailleFont and a BrailleEncoder.</p>
 * <p>Any implementation is not subject to examination and assessment by the EP2-Team, but serves as
 * free test hub for students.</p>
 */
public class Application {
    public static void main(String[] args) {

        // example from documentation
        LineBuffer lineBuffer = new BrailleLineBuffer(3, 1.5, 0.3);
        AdvancedLinePrinter lp = new AdvancedLinePrinter(
                new BrailleFont(
                        3,
                        2,
                        'o',
                        '.',
                        new BrailleEncoder()),
                4,
                lineBuffer
        );
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());
        lp.printString("Hello");
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.printString(" World");
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        System.out.println("modifying buffer...");
        lp.deleteCharacter(2);
        lp.insertCharacter(2, 'a');
        lp.deleteCharacter(3);
        lp.insertCharacter(3, 'r');
        lp.deleteCharacter(4);
        lp.deleteCharacter(8);
        lp.insertCharacter(5, 'm');
        lp.insertCharacter(6, 'y');
        lp.insertCharacter(7, ' ');
        System.out.printf("buffer size: %d,  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.flush();
        System.out.printf("buffer size: %d  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.printString("OK");
        System.out.printf("buffer size: %d  characters in buffer: %d%n", lineBuffer.size(), lineBuffer.count());

        lp.flush();
        // TODO: implementation of any developer specific tests (optional)
/*        lp.printString("Florian");
        System.out.println(lp.getSpacing());
        lp.printBackSpace();
        lp.flush();

        LineBuffer testLineBuffer = new BrailleLineBuffer(3, 1.5, 0.3);
        char[][] insertBraille = {{'.', '.'}, {'.', '.'}, {'.', '.'}};
        char[][] firBraille = {{'o', 'o'}, {'o', 'o'}, {'o', 'o'}};
        char[][] secBraille = {{'.', '.'}, {'o', 'o'}, {'o', 'o'}};
        char[][] thiBraille = {{'o', 'o'}, {'.', '.'}, {'o', 'o'}};
        char[][] fouBraille = {{'.', '.'}, {'.', '.'}, {'o', 'o'}};

        testLineBuffer.pop();
        testLineBuffer.delete(0);
        testLineBuffer.delete(1);
        testLineBuffer.push(firBraille);
        testLineBuffer.push(secBraille);
        testLineBuffer.push(thiBraille);
        testLineBuffer.push(fouBraille);
        testLineBuffer.insert(0, insertBraille);
        testLineBuffer.insert(7, insertBraille);
        System.out.println(testLineBuffer.renderScanlines(4)[0]);
        System.out.println(testLineBuffer.renderScanlines(4)[1]);
        System.out.println(testLineBuffer.renderScanlines(4)[2]);
        testLineBuffer.delete(1);
        System.out.println(Arrays.deepToString(testLineBuffer.pop()));
        testLineBuffer.delete(1);
        System.out.println(Arrays.deepToString(testLineBuffer.pop()));
        System.out.println(Arrays.deepToString(testLineBuffer.pop()));
        System.out.println(Arrays.deepToString(testLineBuffer.pop()));
        System.out.println(Arrays.deepToString(testLineBuffer.pop()));*/
    }
}