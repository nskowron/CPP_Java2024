public class Pentagon extends Shape
{
    protected final double side;
    protected final String name;

    public Pentagon(double side) throws IllegalArgumentException
    {
        if(side < 0)
        {
            throw new IllegalArgumentException("Pentagon side cannot be negative, got: " + side);
        }
        this.side = side;
        this.name = "Pentagon";
    }

    public double Circumference()
    {
        return 5 * side;
    }

    public double Area()
    {
        return 5 * side * (1 / Math.tan(Math.toRadians(36)));
    }

    public String Name()
    {
        return name;
    }
}