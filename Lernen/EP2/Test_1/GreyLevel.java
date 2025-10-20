/**
 * This class represents a greyscale level that is represented both as an
 * integer index and as a corresponding character from a predefined scale.
 *
 * The mapping of characters to greyscale levels is defined by the constant {@code GREY_SCALE},
 * where the lowest level (0) corresponds to the first character in the string and higher levels
 * are assigned to subsequent characters.
 *
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public class GreyLevel {

    /**
     * The mapping of grey levels to characters. Each character in this string
     * represents a different grey intensity level.
     */
    public static final String GREY_SCALE = " .:-=+*#%@";
    private int level;

    /**
     * Checks whether the specified character is a valid grey level character.
     * A valid character is defined as one that exists in {@code GREY_SCALE}.
     *
     * @param ASCIIchar the character to check for validity.
     * @return {@code true} if the character is present in {@code GREY_SCALE},
     *         {@code false} otherwise.
     */
    public static boolean isValid(char ASCIIchar) {

        return GREY_SCALE.contains(Character.toString(ASCIIchar));
    }

    /**
     * Initializes this {@code GreyLevel} using a specified integer level.
     *
     * @param level the integer level, which should be a valid index in {@code GREY_SCALE}.
     */
    public GreyLevel(int level) {

        this.level = level;
    }

    /**
     * Constructs a {@code GreyLevel} using a character.
     *
     * The constructor determines the grey level by finding the index of the specified character
     * within the {@code GREY_SCALE}.
     *
     * @param ASCIIchar the character representing the grey level, which must be present in
     *                  {@code GREY_SCALE}.
     */
    public GreyLevel(char ASCIIchar) {

        this.level = GREY_SCALE.indexOf(ASCIIchar);
    }

    /**
     * Checks whether this is grey level 0.
     *
     * @return {@code true} if {@code this} corresponds to the minimal grey level 0,
     *         {@code false} otherwise.
     */
    public boolean isBackground() {

        return this.level == 0;
    }

    /**
     * Returns the integer level associated with this {@code GreyLevel}.
     *
     * @return the integer level corresponding to this grey level.
     */
    public int getInt() {

        return level;
    }

    /**
     * Returns the character corresponding to this grey level.
     * The character is determined by accessing the character at the position specified by
     * in {@code GREY_SCALE}.
     *
     * @return the character representation of this grey level.
     */
    public char getChar() {

        return GREY_SCALE.charAt(level);
    }

    /**
     * Returns a string representation, which is the getInt()-value as a string.
     *
     * @return the getInt()-value as a string.
     */
    @Override
    public String toString() {

        return Integer.toString(level);
    }
}
