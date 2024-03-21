import java.util.ArrayList;

public class Primes 
{ 
    private int n;
    public ArrayList<Integer> primes;

    public Primes(final int n) throws IllegalArgumentException
    {
        if(n < 0)
        {
            throw new IllegalArgumentException("n should be >= 0, got " + n);
        }
        this.n = n;

        primes = Sieve.sieve_make(n);
    }

    public int get(final int n)
    {
        if(n < 0 || n > primes.size())
        {
            throw new IllegalArgumentException("Provided id: "+ (n+1) +" is out of range:");
        }

        return primes.get(n);
    }

}