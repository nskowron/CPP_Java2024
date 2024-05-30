import java.util.Map;

/**
 * Instantiates Drawable objects based on provided DrawableObjectData.
 */
public class DrawableObjectInstantiator {

    // Map to store suppliers for different types of Drawable objects
    private Map<String, DrawableObjectSupplier> typeMap;

    /**
     * Constructs a new DrawableObjectInstantiator with the specified type map.
     * @param typeMap The map containing suppliers for different types of Drawable objects.
     * @brief Constructs a new DrawableObjectInstantiator with the specified type map.
     */
    public DrawableObjectInstantiator(Map<String, DrawableObjectSupplier> typeMap) {
        this.typeMap = typeMap;
    }

    /**
     * Instantiates a Drawable object based on the provided DrawableObjectData.
     * @param data The data used to instantiate the Drawable object.
     * @return The instantiated Drawable object.
     * @throws IllegalArgumentException If the Drawable object type is not found in the type map.
     * @brief Instantiates a Drawable object based on the provided DrawableObjectData.
     */
    public Drawable instantiate(DrawableObjectData data) throws IllegalArgumentException {
        // Get the supplier for the specified object type
        DrawableObjectSupplier supplier = typeMap.get(data.type);
        if(supplier == null) {
            throw new IllegalArgumentException("Could not instantiate " + data.type);
        }
        // Use the supplier to instantiate the Drawable object
        return supplier.get(data);
    }
}
