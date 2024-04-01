import java.util.Arrays;

public class Algorythm
{
    private Algorythm() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of class Algorythm");
    }

    public static double [] Sorted(double [] array)
    {
        Arrays.sort(array);
        return array;
    }
}
