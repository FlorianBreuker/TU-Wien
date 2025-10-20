import java.util.NoSuchElementException;

/**
 * This class can be modified and is for testing your solution.
 * Modifications will NOT be reviewed or assessed.
 */
public class PraxisTest2 {

    /**
     * The main method.
     *
     * @param args not used.
     */
    public static void main(String[] args) {
        System.out.println("Test 'equals':");
        IntConst ONE = new IntConst(1);
        IntConst TWO = new IntConst(2);
        IntConst THREE = new IntConst(3);

        testEquals(ONE, new IntConst(1));
        testEquals(TWO, new IntConst(2));
        testEquals(ONE, TWO, false);
        testEquals(ONE.hashCode(), new IntConst(1).hashCode());
        testEquals(TWO.hashCode(), new IntConst(2).hashCode());

        CompactIntConstSet set1 = new CompactIntConstSet();
        set1.add(ONE);
        CompactIntConstSet set2 = new CompactIntConstSet();
        set2.add(new IntConst(1));
        testEquals(set1, set2);
        set1.add(new IntConst(5));
        set1.add(THREE);
        set1.add(TWO);
        testEquals(set1, set2, false);

        System.out.println("\nTest 'contains':");
        testEquals(set1.contains(new IntConst(4)), false);
        testEquals(set1.contains(new IntConst(1)), true);
        testEquals(set1.contains(new IntConst(2)), true);
        testEquals(set1.contains(new IntConst(3)), true);
        testEquals(set1.contains(new IntConst(5)), true);

        System.out.println("\nTest 'toString':");
        testEquals(set1.toString(), "1-3,5");
        set1.add(new IntConst(6));
        testEquals(set1.toString(), "1-3,5-6");
        testEquals(set2.toString(), "1");

        System.out.println("\nTest constructor of 'IntConstRangeSet':");
        try {
            IntConstRangeSet rangeSet = new IntConstRangeSet(ONE, ONE);
            testEquals(rangeSet.contains(new IntConst(1)), true);
            testEquals(rangeSet.contains(new IntConst(0)), false);
            testEquals(rangeSet.contains(new IntConst(2)), false);
            rangeSet = new IntConstRangeSet(new IntConst(2), new IntConst(1));
            System.out.println("Test NOT successful! Statement should not be reached.");
        } catch (IllegalLimitException e) {
            System.out.println("Successful test");
            testEquals(e.getMessage(), "illegal range limits");
        }

        System.out.println("\nTest 'getRangeView':");
        IntConstRange r = new IntConstRangeSet(ONE, ONE).getRangeView();
        testEquals(r.getSmallest(), ONE);
        testEquals(r.getLargest(), ONE);
        testEquals(r.getLargest(), ONE);

        r = set1.getRangeView();
        testEquals(r.getSmallest(), ONE);
        testEquals(r.getLargest(), new IntConst(6));
        set1.add(new IntConst(10));
        testEquals(r.getLargest(), new IntConst(10));
        r = set2.getRangeView();
        testEquals(r.getSmallest(), ONE);
        testEquals(r.getLargest(), ONE);

        System.out.println("\nTest 'union':");
        IntConstSet set = new IntConstRangeSet(ONE, ONE).union(new IntConstRangeSet(THREE, THREE))
                .union(new IntConstRangeSet(TWO, TWO));
        testEquals(set.toString(), "1-3");
        testEquals(set1.union(set2), set1);
        testEquals(set1.union(set2).toString(), "1-3,5-6,10");
        testEquals(set1.union(set2).union(new IntConstRangeSet(new IntConst(11), new IntConst(11))).toString(), "1-3,5-6,10-11");

        System.out.println("\nTest 'iterator':");
        set1 = new CompactIntConstSet();
        set1.add(ONE);
        set1.add(TWO);
        set1.add(THREE);
        set1.add(new IntConst(5));
        set1.add(new IntConst(6));
        IntConstIterator iter = set1.iterator();
        for (int i = 1; i <= 6; i++) {
            if (i != 4) {
                testEquals(iter.next(), new IntConst(i));
            }
        }
        try {
            testEquals(iter.hasNext(), false);
            iter.next();
            System.out.println("Test NOT successful! Statement should not be reached.");
        } catch (NoSuchElementException e) {
            System.out.println("Successful test");
            testEquals(e.getMessage(), "no element!");
        }

    }

    public static void testEquals(Object given, Object expected) {
        if (given.equals(expected)) {
            System.out.println("Successful test");
        } else {
            System.out.println("Test NOT successful! Expected value: " + expected.toString() + " / Given " +
                    "value: " + given.toString());
        }
    }

    public static void testEquals(Object first, Object second, boolean expected) {
        if (first.equals(second) == expected) {
            System.out.println("Successful test");
        } else {
            if (expected) {
                System.out.println("Test NOT successful! " + first.toString() +
                        " must be equal to " + second.toString());
            } else {
                System.out.println("Test NOT successful! " + first.toString() +
                        " must not be equal to " + second.toString());
            }
        }
    }
}
