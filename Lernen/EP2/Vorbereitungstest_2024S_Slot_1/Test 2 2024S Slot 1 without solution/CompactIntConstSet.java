import java.util.ArrayList;
import java.util.Collections;

/**
 * A 'CompactIntConstSet' implements 'IntConstSet' as a collection of
 * non-overlapping, non-consecutive 'IntConstRangeSet' objects. Consecutive
 * ranges are stored as a single 'IntConstRangeSet' object, rather than two
 * separate objects. For example, instead of a set storing two objects 3-5 and 6-9 the set is
 * represented internally by a single object 3-9 of class 'IntConstRangeSet'.
 */

public class CompactIntConstSet implements IntConstSet // TODO: uncomment clause.
{
    ArrayList<IntConst>[] list;

    /**
     * Initialises 'this' as an empty set.
     */
    public CompactIntConstSet() {
        this.list = new ArrayList[]{new ArrayList<>()};
    }

    /**
     * Adds the specified element 'e' to this set if the set contains no element 'e2' such that
     * e.equals(e2). If this set already contains such an element, the call leaves the set unchanged.
     *
     * @param e the element to be added to the set, e != null.
     */
    public void add(IntConst e) {
        list[0].add(e);
    }

    /**
     * Returns a readable representation of the set. The representation shows the numbers in
     * ascending order separated by ','. Wherever a range of consecutive numbers from n to m
     * appears in the representation this representation is in the form n-m.
     * <p>
     * Example:
     * 1,3,6-9,12-20,22.
     *
     * @return a readable representation of the set.
     */
    public String toString() {
        StringBuilder res = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();


        for (IntConst ic : list[0]) {
            arr.add(ic.hashCode());
        }

        Collections.sort(arr);

        int i = 0;
        while (i < arr.size()) {
            res.append(arr.get(i).hashCode());
            if (i < arr.size() - 1 && arr.get(i + 1) == (arr.get(i) + 1)) {
                while (i < arr.size() - 1 && arr.get(i + 1) == (arr.get(i) + 1)) {
                    i++;
                }
                res.append("-").append(arr.get(i));
            }
            if (i < arr.size() - 1) res.append(",");
            i++;
        }
        return res.toString();
    }

    @Override
    public IntConstRange getRangeView() {
        return new CompactView(this, list);
    }

    @Override
    public boolean contains(IntConst element) {
        return list[0].contains(element);
    }

    /**
     * Returns the union of this set and the specified set (see specification in 'IntConstSet').
     * The method returns a new object of the most specific subtype of 'IntConstSet':
     * The returned object is of 'IntConstRangeSet' if the returned set can be represented by a
     * single range. Otherwise, the returned set is of 'CompactIntConstSet'.
     *
     * @param other the other set, other != null.
     * @return a new set representing the union of 'this' with 'other'.
     */
    //@Override
    public IntConstSet union(IntConstSet other) {
        return null;
    }

    /**
     * Returns 'true' if 'o' is also of class 'CompactIntConstSet' and represents the same
     * set as 'this' in a mathematical sense (has equal 'IntConst' elements).
     * Otherwise, 'false' is returned.
     * The method should not compare objects by using their toString() method.
     *
     * @param o the other object to compare with.
     * @return 'true' if 'this' and 'o' are equal and 'false' otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this.getClass() != o.getClass()) return false;
        CompactIntConstSet that = (CompactIntConstSet) o;
        for (IntConst ic : this.list[0]) {
            if (!that.contains(ic)) return false;
        }
        for (IntConst ic : that.list[0]) {
            if (!this.contains(ic)) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (IntConst ic : list[0]) {
            hashCode += ic.hashCode();
        }
        return hashCode;
    }

    @Override
    public IntConstIterator iterator() {
        return new CompactIterator(list[0].iterator());
    }
}
