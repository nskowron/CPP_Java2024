import java.util.Map;

public class DrawableObjectInstantiator
{
    private Map<String, DrawableObjectSupplier> typeMap;

    public DrawableObjectInstantiator(Map<String, DrawableObjectSupplier> typeMap)
    {
        this.typeMap = typeMap;
    }

    public Drawable instantiate(DrawableObjectData data) throws IllegalArgumentException
    {
        DrawableObjectSupplier supplier = typeMap.get(data.type);
        if(supplier == null)
        {
            throw new IllegalArgumentException("Could not instantiate " + data.type);
        }
        return supplier.get(data);
    }
}
