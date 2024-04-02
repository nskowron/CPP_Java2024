public class Hexagon extends Shape
{
    protected final double side;
    protected final String name;

    public Hexagon(double side) throws IllegalArgumentException
    {
        if(side < 0)
        {
            throw new IllegalArgumentException("Hexagon side cannot be negative, got: " + side);
        }
        this.side = side;
        this.name = "Hexagon";
    }

    public double Circumference()
    {
        return 6 * side;
    }

    public double Area()
    {
        return 1.5 * Math.sqrt(3) * side * side;
    }

    public String Name()
    {
        return name;
    }
}
