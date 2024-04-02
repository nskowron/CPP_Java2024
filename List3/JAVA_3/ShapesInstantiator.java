public class ShapesInstantiator
{
    private ShapesInstantiator() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of class ShapeInstantiator");
    }

    public static Shapes.Shape_OneParam CreateShape_OneParam(String type) throws IllegalArgumentException
    {
        switch(type)
        {
            case "o":
                return Shapes.Shape_OneParam.CIRCLE;
            
            case "s":
                return Shapes.Shape_OneParam.SQUARE;

            case "p":
                return Shapes.Shape_OneParam.PENTAGON;

            case "h":
                return Shapes.Shape_OneParam.HEXAGON;

            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }

    public static Shapes.Shape_TwoParam CreateShape_TwoParam(String type) throws IllegalArgumentException
    {
        switch(type)
        {
            case "re":
                return Shapes.Shape_TwoParam.RECTANGLE;
            
            case "rh":
                return Shapes.Shape_TwoParam.RHOMBUS;

            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}
