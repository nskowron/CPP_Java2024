public class Math 
{
    private Math() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron.");
    }

    public static long NewtonSymbol(final int n, final int k)
    {
        if(n < 0 || k < 0)
        {
            throw new IllegalArgumentException("Arguments can't be negative (" + n + ", " + k + ")");
        }
        if(k > n)
        {
            throw new IllegalArgumentException("k(" + k + ") must be <= n(" + n + ")");
        }

        long result = 1;
        for(int i = 1; i <= k; ++i)
        {
            result *= n - k + i;
            result /= i;
        }
        return result;
    }
}