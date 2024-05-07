package builders;

/**
 * A Builder for constructing rectangular play spaces.
 */
public class RectangularBuilder implements Builder {
    private int width;
    private int height;

    /**
     * Sets the width of rectangular play space.
     *
     * @param width The width of rectangular play space.
     */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Sets the height of rectangular play space.
     *
     * @param height The height of rectangular play space.
     */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Builds rectangular play space.
     */
    @Override
    public void build() {
        System.out.println("Building rectangular play space with width: " + width + " and height: " + height);
    }
}
