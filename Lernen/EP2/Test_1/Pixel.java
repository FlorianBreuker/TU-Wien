/**
 * This class encapsulates the information of a single pixel in an image.
 * Each pixel is characterized by a specific {@link Position} and an associated {@link GreyLevel},
 * which represents its brightness or grey level.
 *
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public class Pixel {

    private Position position;
    private GreyLevel greyLevel;

    /**
     * Constructs a {@code Pixel} with the specified position and grey level.
     *
     * @param position  the position of the pixel; {@code position != null}.
     * @param greyLevel the grey level of the pixel; {@code greyLevel != null}.
     */
    public Pixel(Position position, GreyLevel greyLevel) {

        this.position = position;
        this.greyLevel = greyLevel;
    }

    /**
     * Returns the grey level of this pixel.
     *
     * @return the {@code GreyLevel} associated with this pixel.
     */
    public GreyLevel getGreyLevel() {

        return greyLevel;
    }

    /**
     * Returns the position of this pixel in the image.
     *
     * @return the {@code Position} of this pixel.
     */
    public Position getPosition() {

        return position;
    }
}
