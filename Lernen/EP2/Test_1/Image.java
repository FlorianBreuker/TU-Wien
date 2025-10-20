/**
 * This class represents an image constructed as a grid of grey levels. The top-left of the image
 * has position (0, 0), with x increasing to the right and y increasing downward.
 * The image is represented by a {@link SortedSinglyLinkedPixelList} object holding only those pixels with
 * grey levels different from 0.
 * The region of the image is given by the upper left coordinates (0, 0) and lower right
 * coordinates (width - 1, height - 1).
 * All positions inside the image region with no mapping in {@link SortedSinglyLinkedPixelList} implicitly
 * have the lowest grey level of 0.
 */
//
// TODO: Complete the methods in 'Image'.
//       You can define further classes and methods if needed.
//       Do NOT use the Java-Collection framework in 'Image' or in any other class.
//
public class Image {

    //TODO: additional variables, constructors and methods must be private.
    private SortedSinglyLinkedPixelList list;
    private int width;
    private int height;

    /**
     * Constructs an Image from an array of strings.
     * Each string represents a row in the image. For every character in a row that is a valid grey
     * level, the constructor creates and stores the pixel with corresponding position and grey
     * level. The height and width of this image corresponds to the number of strings respectively
     * the length of the strings (each string must be of equal length).
     * Positions with a grey level of 0 are not stored in the list.
     *
     * @param rows an array of strings representing the image rows;
     *             {@code rows != null && rows.length > 0 && rows[0] != null} and all {@code rows[i]}
     *             are of equal length > 0.
     */
    public Image(String[] rows) {
        //TODO: implement constructor.
        this.height = rows.length;
        this.width = rows[0].length();
        this.list = new SortedSinglyLinkedPixelList();

        for (int j = 0; j < rows.length; j++) {
            String row = rows[j];
            for (int i = 0; i < row.length(); i++) {
                GreyLevel gl = new GreyLevel(row.charAt(i));
                if (GreyLevel.isValid(row.charAt(0)) && !gl.isBackground()) {
                    list.insert(new Pixel(new Position(i, j), gl));
                }
            }
        }
    }

    /**
     * Returns the width of the image.
     *
     * @return the width of the image.
     */
    public int width() {
        //TODO: implement method.
        return this.width;
    }

    /**
     * Returns the height of the image.
     *
     * @return the height of the image.
     */
    public int height() {
        //TODO: implement method.
        return this.height;
    }

    /**
     * Returns a new image containing only the columns of this image at or to the right of
     * the specified x-coordinate. The returned image has the same width and height as this
     * image; pixels with an x-coordinate less than {@code x} are omitted (implicitly set to grey 0).
     * <p>
     * All pixels in this image whose x-coordinate is ≥ {@code x} are copied into the new image
     * at their original positions. Pixels with x < {@code x} do not appear in the new image’s
     * internal list and are treated as grey level 0.
     * </p>
     *
     * @param x the column index (inclusive) from which to copy pixels; must satisfy
     *          {@code 0 <= x < this.width()}.
     * @return a new {@code Image} of the same dimensions, containing only the right-hand part
     * of this image from column {@code x} onward
     */
    public Image copyRightPart(int x) {
        //TODO: implement method.
        SortedSinglyLinkedPixelList toBePrinted = list.copyGreaterEqualTo(new Position(x, 0));
        String[] output = new String[height];

        for (int i = 0; i < output.length; i++) {
            output[i] = "";
            for (int j = 0; j < width; j++) {
                GreyLevel pixel = toBePrinted.getGreyLevel(new Position(j, i));
                if (pixel != null) {
                    output[i] += pixel.getChar();
                } else output[i] += " ";
            }
        }
        return new Image(output);
    }

    /**
     * Returns the image as an array of strings, where each string represents one row in the image.
     * Each position of one row is represented by the corresponding grey level character if
     * present, or a space character ' ' if no grey level is stored
     * (space corresponds to grey level 0).
     * <p>
     * If width and height of this image are both zero, an empty array is returned (no rows).
     *
     * @return a string representing the image (as specified in the constructor of this class).
     */
    public String[] asArray() {

        String[] result = new String[this.height()];
        for (int i = 0; i < this.height(); i++) {
            String row = "";
            for (int j = 0; j < this.width(); j++) {
                row += list.getGreyLevel(new Position(j, i)) == null ? " " :
                        list.getGreyLevel(new Position(j, i)).getChar();

            }
            result[i] = row;
        }
        return result;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).