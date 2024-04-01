public class Circle extends Shape 
{
    protected double radius;

    public Circle(double radius) throws IllegalArgumentException
    {
        if(radius < 0)
        {
            throw new IllegalArgumentException("Radius cannot be negative: " + radius);
        }
        this.radius = radius;
    }

    public double Circumference()
    {
        return 2.0 * Math.PI * radius;
    }

    public double Area()
    {
        return Math.PI * radius * radius;
    }
}
