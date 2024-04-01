public class Rhombus extends Quad
{
    public Rhombus(double [] sides, double angle)
    {
        super(sides, angle);

        if(sides[0] != sides[1] || sides[1] != sides[2] || sides[2] != sides[3])
        {
            throw new IllegalArgumentException("Rhombus should have all sides equal: " + sides[0] + ", " + sides[1] + ", " + sides[2] + ", " + sides[3]);
        }
    }

    public double Area()
    {
        return sides[0] * sides[0] * Math.sin(angle);
    }
}