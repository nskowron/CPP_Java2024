/**
 * Represents a supplier interface for instantiating Drawable objects.
 */
public interface DrawableObjectSupplier {

    /**
     * Gets a Drawable object based on the provided DrawableObjectData.
     * @param data The data used to instantiate the Drawable object.
     * @return The instantiated Drawable object.
     * @brief Gets a Drawable object based on the provided DrawableObjectData.
     */
    public Drawable get(DrawableObjectData data);
}
