public class Rectangle extends Quad
{
    public Rectangle(double [] sides) throws IllegalArgumentException
    {
        super(Algorythm.Sorted(sides), 90, "Rectangle");

        if(this.sides[0] != this.sides[1] || this.sides[2] != this.sides[3])
        {
            throw new IllegalArgumentException("Rectanle cannot have more than 2 different sides: " + sides[0] + ", " + sides[1] + ", " + sides[2] + ", " + sides[3]);
        }
    }

    public double Area()
    {
        return sides[0] * sides[2];
    }
}
