import java.util.ArrayList;

public class Sieve  
{
    private Sieve() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron.");
    }

    public static ArrayList<Integer> sieve_make(final int n)
    {
        if(n <= 2)
        {
            throw new IllegalArgumentException("Argument has to be >= 2 (" + n + ")");
        }

        boolean[] prime = new boolean[n];

        for (int i = 0; i < n; i++)
        {
            prime[i] = true;
        }

        for(int p = 2; p*p < n; p++)
        {
            if(prime[p])
            {
                for(int i = p*p; i < n; i += p)
                {
                    prime[i]=false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<Integer>();

        for(int j = 2; j < n; j++)
        {
            if(prime[j])
            {
                primes.add(j); 
            }
        }

        return primes;
    }
}