/**
 * This singly linked list stores pixels as elements. The elements in this list are ordered
 * according to the pixel's position, i.e., by the natural order defined in the {@code Position} class
 * via its {@code compareTo} method. For any two pixels in this list with positions p1 and p2,
 * it holds that: p1.compareTo(p2) != 0.
 * There is no limit on the number of elements stored in this list.
 */
//
// TODO: Complete the methods in 'SortedSinglyLinkedPixelList'.
//       You can define further classes and methods for the implementation of the
//       binary search tree if needed.
//       Do NOT use the Java-Collection framework in 'SortedSinglyLinkedPixelList' or in any other
//       class.
//
public class SortedSinglyLinkedPixelList {
    //TODO: additional variables, constructors and methods must be private.
    private PixelNode head;
    private int size;

    /**
     * Initializes this instance as an empty list.
     */
    public SortedSinglyLinkedPixelList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    public int size() {
        int size = 0;
        PixelNode current = this.head;
        while (current != null) {
            size++;
            current = current.getNext();
        }

        return size;
    }

    /**
     * Inserts a new pixel into this list in its sorted position. If a pixel with the same position
     * already exists in this list, its grey level is replaced by the new pixel's grey level and
     * the old grey level is returned.
     * Otherwise, the new pixel is inserted and {@code null} is returned.
     *
     * @param pixel the pixel to be inserted into this list; {@code pixel != null}.
     * @return the old grey level if a pixel with the same position already existed in the list,
     * or {@code null} otherwise.
     */
    public GreyLevel insert(Pixel pixel) {
        //TODO: implement method.
        if (this.head == null) {
            this.head = new PixelNode(null, pixel.getPosition(), pixel.getGreyLevel());
            return null;
        }

        PixelNode current = this.head;
        PixelNode prev = null;
        PixelNode newNode = new PixelNode(null, pixel.getPosition(), pixel.getGreyLevel());

        while (current != null) {
            if (current.getKey().compareTo(newNode.getKey()) == 0) {
                GreyLevel temp = current.getVal();
                current.setVal(pixel.getGreyLevel());
                return temp;
            } else if (current.getKey().compareTo(newNode.getKey()) == -1) {
                prev = current;
                current = current.getNext();
            } else {
                break;
            }
        }

        if (prev == null) {
            this.head = newNode;
            newNode.setNext(current);
        } else {
            prev.setNext(newNode);
            newNode.setNext(current);
        }

        return null;
    }

    /**
     * Removes and returns the last pixel of the list
     * (the one with the "largest" position).
     *
     * @return the last {@code Pixel} in the list, or {@code null} if the list is empty.
     */
    public Pixel removeLast() {
        //TODO: implement method.
        if (head == null) return null;
        PixelNode last = head;
        PixelNode prev = null;
        while (last.getNext() != null){
            prev = last;
            last = last.getNext();
        }
        prev.setNext(null);
        return new Pixel(last.getKey(),last.getVal());
    }

    /**
     * Returns the grey level of the pixel with the specified position.
     * <p>
     * Since the list is sorted by position, this method only traverses as far as needed
     * and stops early if it determines the target cannot be further down the list.
     *
     * @param position the position of the desired pixel; {@code position != null}.
     * @return the grey level of the pixel with the specified position, or {@code null}
     * if no such pixel exists in this list.
     */
    public GreyLevel getGreyLevel(Position position) {
        //TODO: implement method.
        if (head == null) return null;
        PixelNode current = head;
        while (current != null) {
            if (current.getKey().compareTo(position) == 0) {
                return current.getVal();
            } else if (current.getKey().compareTo(position) == 1) return null;
            current = current.getNext();
        }
        return null;
    }

    /**
     * Creates and returns a new list containing all pixels from this list whose position
     * is greater than or equal to the given position, according to {@code Position.compareTo}.
     * {@code this} is not changed by the method.
     * <p>
     * The returned list preserves the original ordering of those pixels.
     * </p>
     *
     * @param position the threshold position; {@code position != null}
     * @return a new {@code SortedSinglyLinkedPixelList} with all pixels whose positions are
     * compare greater than or equal to {@code position}
     */
    public SortedSinglyLinkedPixelList copyGreaterEqualTo(Position position) {
        // TODO: implement method.
        SortedSinglyLinkedPixelList list = new SortedSinglyLinkedPixelList();
        PixelNode current = head;
        while (current != null){
            if (current.getKey().compareTo(position) == 0 || current.getKey().compareTo(position) == 1 ) {
                list.insert(new Pixel(current.getKey(), current.getVal()));
            }
            current = current.getNext();
        }
        return list;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
