public final class Test 
{
    private Test() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron.");
    }

    public static void main(final String[] args)
    {   
        {
        Primes P1 = new Primes(10);
        Primes P2 = new Primes(20);
        Primes P3 = new Primes(3848);
        Primes P4 = new Primes(4993434);
        }

        try
        {
            Primes P5 = new Primes(-10);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            Primes P6 = new Primes(1);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            Primes P7 = new Primes(10);
            P7.get(20);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            Primes P8 = new Primes(10);
            P8.get(-20);
            assert false;
        }
        catch (final IllegalArgumentException e)
        {
            assert true;
        }

        {
            Primes P9 = new Primes(1000);
            assert P9.get(0) == 2;
            assert P9.get(8) == 23;
            assert P9.get(17) == 61;
            assert P9.get(25) == 101;
        }

    }
}
