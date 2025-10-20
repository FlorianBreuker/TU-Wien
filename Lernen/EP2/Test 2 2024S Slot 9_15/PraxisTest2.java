import java.util.HashSet;
import java.util.NoSuchElementException;

/**
 * This class can be modified and is for testing your solution.
 * Modifications will NOT be reviewed or assessed.
 */
public class PraxisTest2 {

    /**
     * The main method.
     * @param args not used.
     */
    public static void main(String[] args) {

        IntVar x = new IntVar("x");
        IntVar y = new IntVar("y");
        IntVar z = new IntVar("z");

        Product m1 = new Product(new IntConstNonNeg(2),x,y,x); //2*x*x*y
        Product m2 = new Product(new IntConstNonNeg(1),y,x,x); //1*x*x*y == x*x*y
        Product m3 = new Product(new IntConstNonNeg(5),y,x);   //5*x*y

        System.out.println("\nTest 'equals' method:");
        testEquals(m1.equals(m2), false);
        testEquals(m3, new Product(new IntConstNonNeg(5),x,y));
        testEquals(new Product(new IntConstNonNeg(2), y,x,x), m1);
        testEquals(new Product(new IntConstNonNeg(3),x,y), m3, false);

        System.out.println("\nTest 'toString' method:");
        // m1.toString should be like 2*x*x*y or 2*x*y*x
        String asString = m1.toString().replaceAll("\\s","");
        testEquals(asString.length(), 7);
        testEquals(asString.contains("2"), true);
        asString = asString.replaceFirst("2", "");
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        testEquals(asString.contains("y"), true);
        asString = asString.replaceFirst("y", "");
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        testEquals(asString, "***");

        Sum s = new Sum();
        testEquals(s.toString(), "0");

        // 3*x*x*y + 5*x*y
        s.add(m1);
        s.add(m2);
        s.add(m3);

        asString = s.toString().replaceAll("\\s","");
        asString = asString.replaceAll("\\*","");
        testEquals(asString.length(), 8);
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        testEquals(asString.length(), 7);
        testEquals(asString.contains("y"), true);
        asString = asString.replaceFirst("y", "");
        testEquals(asString.length(), 6);
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        testEquals(asString.length(), 5);
        testEquals(asString.contains("y"), true);
        asString = asString.replaceFirst("y", "");
        testEquals(asString.contains("x"), true);
        asString = asString.replaceFirst("x", "");
        asString = asString.replaceFirst("3", "");
        asString = asString.replaceFirst("5", "");
        testEquals(asString, "+");

        System.out.println("\nTest 'iterator' method:");
        MonomialIterator iter = x.iterator();
        testEquals(iter.hasNext(), true);
        testEquals(iter.next(), x); //x
        testEquals(iter.hasNext(), false);
        try {
            iter.next();
            System.out.println("Test NOT successful! This message should not be printed.");
        } catch (NoSuchElementException e) {
            testEquals(e.getMessage(), "no monomial!");
        }

        iter = s.iterator();
        // s has two monomials: 3*x*x*y and 5*x*y
        HashSet<Monomial> set1 = new HashSet<>();
        while (iter.hasNext()) {
            set1.add(iter.next());
        }
        HashSet<Monomial> set2 = new HashSet<>();
        set2.add(new Product(new IntConstNonNeg(3),x,x,y));
        set2.add(m3);
        testEquals(set1, set2);

        try {
            iter.next();
            System.out.println("Test NOT successful! This message should not be printed.");
        } catch (NoSuchElementException e) {
            testEquals(e.getMessage(), "no monomial!");
        }

        System.out.println("\nTest 'getSetView' method:");
        IntVarSet view = s.getIntVarSetView();
        testEquals(view.contains(y), true);
        testEquals(view.contains(x), true);
        testEquals(view.contains(z), false);
        s.add(new Product(new IntConstNonNeg(3),x,z));
        testEquals(view.contains(z), true);

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
