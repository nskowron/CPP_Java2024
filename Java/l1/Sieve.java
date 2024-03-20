import java.util.ArrayList;

public class Sieve  
{
    private Sieve() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of a static class Math.");
    }

    public static int[] sieve_make(final int n)
    {
        if(n <= 2)
        {
            throw new IllegalArgumentException("Argument has to be greater or equal to 2 (" + n + ")");
        }

        ArrayList<int> primes = new ArrayList<int>();

        return result;
    }
}