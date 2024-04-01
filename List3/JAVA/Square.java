public class Square extends Quad
{
    public Square(double [] sides) throws IllegalArgumentException
    {
        super(sides, 90, "Square");

        if(sides[0] != sides[1] || sides[1] != sides[2] || sides[2] != sides[3])
        {
            throw new IllegalArgumentException("Square should have all sides equal: " + sides[0] + ", " + sides[1] + ", " + sides[2] + ", " + sides[3]);
        }
    }

    public double Area()
    {
        return sides[0] * sides[0];
    }
}
