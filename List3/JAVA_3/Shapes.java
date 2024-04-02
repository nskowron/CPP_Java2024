public class Shapes
{
    private Shapes() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of static class Shapes");
    }

    public enum Shape_OneParam implements IShape_OneParam 
    {
        CIRCLE, SQUARE, PENTAGON, HEXAGON;

        public double Area(double param1) throws IllegalArgumentException
        {
            return GetInstance(param1).Area();
        }
        public double Circumference(double param1) throws IllegalArgumentException
        {
            return GetInstance(param1).Circumference();
        }
        public String Name()
        {
            return GetInstance(0).Name();
        }
        private IShape GetInstance(double param1) throws IllegalArgumentException
        {
            switch (this)
            {
                case CIRCLE:
                    return new Circle(param1);
            
                case SQUARE:
                    double[] sides_s = {param1, param1, param1, param1};
                    return new Square(sides_s);

                case PENTAGON:
                    return new Pentagon(param1);

                case HEXAGON:
                    return new Hexagon(param1);

                default:
                    throw new IllegalArgumentException("Unknown shape type");
            }
        }
    }

    public enum Shape_TwoParam implements IShape_TwoParam
    {
        RECTANGLE, RHOMBUS;

        public double Area(double param1, double param2) throws IllegalArgumentException
        {
            return GetInstance(param1, param2).Area();
        }
        public double Circumference(double param1, double param2) throws IllegalArgumentException
        {
            return GetInstance(param1, param2).Circumference();
        }
        public String Name()
        {
            return GetInstance(0, 0).Name();
        }
        private IShape GetInstance(double param1, double param2) throws IllegalArgumentException
        {
            switch (this)
            {
                case RECTANGLE:
                    double[] sides_re = {param1, param1, param2, param2};
                    return new Rectangle(sides_re);

                case RHOMBUS:
                    double[] sides_rh = {param1, param1, param1, param1};
                    return new Rhombus(sides_rh, param2);

                default:
                    throw new IllegalArgumentException("Unknown shape type");
            }
        }
    }
}
