import java.util.Arrays;

public class Rectangle extends Quad
{
    public Rectangle(double [] sides) throws IllegalArgumentException
    {
        super(sides, 90);
        Arrays.sort(this.sides);

        if(this.sides[0] != this.sides[1] ||
        this.sides[2] != this.sides[3])
        {
            throw new IllegalArgumentException("Rectanle cannot have more than 2 different sides: " + sides[0] + ", " + sides[1] + ", " + sides[2] + ", " + sides[3]);
        }
    }
    public double Area()
    {
        return sides[0] * sides[2];
    }
}
