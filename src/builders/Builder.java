package builders;
/**
 * A Builder interface for constructing play spaces.
 */
public interface Builder {
    /**
     * Sets the width of the play space.
     * @param width The width of the play space.
     */
    public void setWidth(int width);

    /**
     * Sets the height of the play space.
     * @param height The height of the play space.
     */
    public void setHeight(int height);

    /**
     * Builds the play space.
     * @throws IllegalArgumentException If the play space cannot be built with the given parameters.
     */
    public void build() throws IllegalArgumentException;
}
