import java.util.Arrays;

/**
 * This class can be modified and is for testing your solution.
 * Modifications will NOT be reviewed or assessed.
 */
public class ApplicationTest1 {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        String[] EP2 =
                new String[]{
                        "                                                     :%@@@@+     ",
                        "-@@@@@@@@@@@@@@@@@:      +@@@@@@@@@@%+.            @@@:. ..@@@.  ",
                        "   +@           +@:         %@      .+@@@.       .@@         %@+ ",
                        "   +@           +@:         %@          %@+      @@           @@ ",
                        "   +@           =@:         %@           @@                   @@ ",
                        "   +@     .@*               %@           @@                 .@@. ",
                        "   +@.....:@%               %@         .@@:                #@%   ",
                        "   +@%%%%%%@%               %@++++++#@@@*                *@@.    ",
                        "   +@     .@%               %@=====-:.                 *@@.      ",
                        "   +@            +@         %@                       #@@.        ",
                        "   +@            #@         %@                     *@@.          ",
                        "   +@            #@         %@                   #@@.         :- ",
                        "=@@@@@@@@@@@@@@@@@@      +@@@@@@@@@@-           +@@@@@@@@@@@@@@@."
                };

        String[] targetCopied =
                new String[]{
                        "                                                     :%@@@@+     ",
                        "                            @@@@@@@@%+.            @@@:. ..@@@.  ",
                        "                            %@      .+@@@.       .@@         %@+ ",
                        "                            %@          %@+      @@           @@ ",
                        "                            %@           @@                   @@ ",
                        "                            %@           @@                 .@@. ",
                        "                            %@         .@@:                #@%   ",
                        "                            %@++++++#@@@*                *@@.    ",
                        "                            %@=====-:.                 *@@.      ",
                        "                            %@                       #@@.        ",
                        "                            %@                     *@@.          ",
                        "                            %@                   #@@.         :- ",
                        "                            @@@@@@@@-           +@@@@@@@@@@@@@@@."
                };

        System.out.println("Test 'SortedDoublyLinkedPixelList' ...");
        System.out.println("Test 'insert', 'getGreyLevel' and 'size' method:");
        SortedSinglyLinkedPixelList list = new SortedSinglyLinkedPixelList();
        testIdentical(list.insert(new Pixel(new Position(7, 1), new GreyLevel(1))), null);
        testIdentical(list.insert(new Pixel(new Position(2, 0), new GreyLevel(5))), null);
        list.insert(new Pixel(new Position(12, 3), new GreyLevel(0)));
        testEquals(list.insert(new Pixel(new Position(7, 1), new GreyLevel(3))), new GreyLevel(1));
        testEquals(list.getGreyLevel(new Position(2, 0)), new GreyLevel(5));
        testIdentical(list.getGreyLevel(new Position(10, 3)), null);
        testEquals(list.size(), 3);
        System.out.println("Test 'removeLast' method:");
        Pixel p = list.removeLast();
        testEquals(p.getPosition(), new Position(12, 3));
        testEquals(list.size(), 2);
        testEquals(list.getGreyLevel(new Position(2, 0)), new GreyLevel(5));
        testEquals(list.getGreyLevel(new Position(7, 1)), new GreyLevel(3));
        testEquals(list.getGreyLevel(new Position(12, 3)), null);
        p = list.removeLast();
        testEquals(p.getPosition(), new Position(7, 1));
        testEquals(list.size(), 1);
        testEquals(list.getGreyLevel(new Position(7, 1)), null);
        testEquals(list.getGreyLevel(new Position(2, 0)), new GreyLevel(5));


        System.out.println("Test 'copyGreaterEqualTo' method:");
        list = new SortedSinglyLinkedPixelList();
        list.insert(new Pixel(new Position(2, 0), new GreyLevel(5)));
        list.insert(new Pixel(new Position(7, 1), new GreyLevel(3)));
        list.insert(new Pixel(new Position(12, 3), new GreyLevel(0)));
        list.insert(new Pixel(new Position(12, 4), new GreyLevel(1)));
        SortedSinglyLinkedPixelList anotherList = list.copyGreaterEqualTo(new Position(2, 1));
        testEquals(anotherList.size(), 3);
        testEquals(anotherList.getGreyLevel(new Position(2, 0)), null);
        testEquals(anotherList.getGreyLevel(new Position(7, 1)), new GreyLevel(3));
        list.insert(new Pixel(new Position(1, 1), new GreyLevel(2)));
        anotherList.insert(new Pixel(new Position(7, 0), new GreyLevel(5)));
        testEquals(list.getGreyLevel(new Position(7, 0)), null);
        testEquals(anotherList.getGreyLevel(new Position(1, 1)), null);
        testEquals(list.getGreyLevel(new Position(1, 1)), new GreyLevel(2));
        testEquals(anotherList.getGreyLevel(new Position(7, 0)), new GreyLevel(5));

        System.out.println("Test 'Image' ...");
        System.out.println("Test constructor:");
        Image i1 = new Image(EP2);
        testEquals(i1.asArray(), EP2);

        System.out.println("Test 'width' and 'height':");
        testEquals(i1.width(), 65);
        testEquals(i1.height(), 13);

        System.out.println("Test 'copyRightPart':");
        testEquals(i1.copyRightPart(28).asArray(), targetCopied);
    }

    /**
     * Checks two objects for identity and prints "OK" only if given == expected.
     * @param given the given object.
     * @param expected the expected object.
     */
    public static void testIdentical(Object given, Object expected) {

        if (given == expected) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given value: " + given);
        }
    }

    /**
     * Compares two objects for equality using the 'equals' method.
     * Prints "OK" if and only if
     * (given == null ? expected == null : given.equals(expected) == 0)
     * @param given the given object.
     * @param expected the object to compare 'given' to.
     */
    public static void testEquals(Object given, Object expected) {

        if (given == null ? expected == null : given.equals(expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }

    /**
     * Compares two 'Position' objects for equality using the 'compareTo' method.
     * Prints "OK" if and only if
     * (given == null ? expected == null : expected != null && given.compareTo(expected) == 0)
     * @param given the given position.
     * @param expected the position to compare 'given' to.
     */
    public static void testEquals(Position given, Position expected) {

        if (given == null ? expected == null : expected != null && given.compareTo(expected) == 0) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }

    /**
     * Compares two 'Position' objects for equality using the 'compareTo' method.
     * Prints "OK" if and only if
     * (given == null ? expected == null : expected != null && given.compareTo(expected) == 0)
     * @param given the given image as array.
     * @param expected the expected image as array.
     */
    public static void testEquals(String[] given, String[] expected) {
        if (given == null ? expected == null : expected != null
                && Arrays.deepEquals(given, expected)) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected: ");
            if (expected == null) {
                System.out.println("null");
            } else {
                for (String s : expected) {
                    System.out.println("\033[48;5;240m"+s+"\033[0m");
                }
            }

            System.out.println("Given: ");
            if (given == null) {
                System.out.println("null");
            } else {
                for (String s : given) {
                    System.out.println("\033[48;5;240m"+s+"\033[0m");
                }
            }
        }
    }

    /**
     * Compares two 'GreyLevel' objects for equality.
     * Prints "OK" if and only if
     * (given == null ? expected == null : expected != null &&
     *                 given.getInt() == expected.getInt())
     * @param given the given grey level.
     * @param expected the grey level to compare 'given' to.
     */
    public static void testEquals(GreyLevel given, GreyLevel expected) {
        if (given == null ? expected == null : expected != null &&
                given.getInt() == expected.getInt()) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL! Expected value: " + expected + " / Given " +
                    "value: " + given);
        }
    }
}