public final class PascalsTriangle
{
    private int n;

    public PascalsTriangle(int n) throws IllegalArgumentException
    {
        if(n < 0)
        {
            throw new IllegalArgumentException("n should be >= 0, got " + n);
        }
        this.n = n;
    }

    public long Element(int m) throws IllegalArgumentException
    {
        if(m < 0 || m > n)
        {
            throw new IllegalArgumentException("m should be 0 < m < " + n + ", got " + m);
        }
        return Math.NewtonSymbol(n, m);
    }

    public long[] Row()
    {
        // upewnij sie ze na pewno nie oddasz referencji do lokalnej zmiennej
        long [] result = new long [n + 1];
        for(int m = 0; m <= n; ++m)
        {
            result[m] = Math.NewtonSymbol(n, m);
        }
        return result;
    }
}