package director;

import builders.Builder;

/**
 * The Director class coordinates the construction process of play spaces.
 */
public class Director {
    /**
     * Constructs a rectangular play space using the provided builder, width, and height.
     * @param builder The builder to use for constructing the play space.
     * @param width The width of the rectangular play space.
     * @param height The height of the rectangular play space.
     */
    public void constructRectangularPlaySpace(Builder builder, int width, int height) {
        builder.setWidth(width);
        builder.setHeight(height);
    }

    /**
     * Constructs a circular play space using the provided builder and radius.
     * @param builder The builder to use for constructing the play space.
     * @param radius The radius of the circular play space.
     */
    public void constructCircularPlaySpace(Builder builder, int radius) {
        builder.setHeight(radius);
        builder.setWidth(radius);
    }
}
