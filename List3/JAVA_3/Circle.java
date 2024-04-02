public class Circle extends Shape 
{
    protected final double radius;
    protected final String name;

    public Circle(double radius) throws IllegalArgumentException
    {
        if(radius < 0)
        {
            throw new IllegalArgumentException("Radius cannot be negative, got: " + radius);
        }
        this.radius = radius;
        this.name = "Circle";
    }

    public double Circumference()
    {
        return 2.0 * Math.PI * radius;
    }

    public double Area()
    {
        return Math.PI * radius * radius;
    }

    public String Name()
    {
        return name;
    }
}
