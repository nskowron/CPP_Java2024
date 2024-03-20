public class Primes 
{ 
    private int n;
    public int[] primes;

    public Primes(final int n) throws IllegalArgumentException
    {
        if(n < 0)
        {
            throw new IllegalArgumentException("n should be >= 0, got " + n);
        }
        this.n = n;
    }

}