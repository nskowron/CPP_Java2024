public abstract class Quad extends Shape
{
    protected double [] sides;
    protected double angle;

    public Quad(double [] sides, double angle) throws IllegalArgumentException
    {
        if(sides.length != 4)
        {
            throw new IllegalArgumentException("A quad needs to have 4 sides, got: " + sides.length);
        }
        if(sides[0] < 0 || sides[1] < 0 || sides[2] < 0 || sides[3] < 0)
        {
            throw new IllegalArgumentException("A quad cannot have negative side lengths: " + sides[0] + ", " + sides[1] + ", " + sides[2] + ", " + sides[3]);
        }
        if(angle < 0 || angle >= 180)
        {
            throw new IllegalArgumentException("A quad should have an angle between 0 and 180, got: " + angle);
        }

        this.sides = sides;
        this.angle = angle;
    }

    public double Circumference()
    {
        return sides[0] + sides[1] + sides[2] + sides[3];
    }
}
