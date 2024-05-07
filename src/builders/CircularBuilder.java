package builders;

/**
 * A Builder for constructing circular play spaces.
 */

public class CircularBuilder implements Builder {
    private int height;
    private int width;

    /**
     * Sets the width of сircular play space.
     * @param width The width of сircular play space.
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the height of сircular play space.
     * @param height The height of сircular play space.
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Builds сircular play space.
     * @throws IllegalArgumentException If сircular play space cannot be built with the given parameters.
     */
    @Override
    public void build() throws IllegalArgumentException {
        if (width != height)
            throw new IllegalArgumentException("Width must be equal to height");
        System.out.println("Building circular play space with radius: " + height);
    }
}