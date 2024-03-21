public final class Test
{
    private Test() throws InstantiationError
    {
        throw new InstantiationError("This is a static class you moron.");
    }

    public static void main(final String[] args)
    {
        TestNewtonSymbol();
        TestPascalsTriangle();
    }

    public static void TestPascalsTriangle()
    {
        {
            PascalsTriangle PT = new PascalsTriangle(4);
            assert PT.Element(0) == 1;
            assert PT.Element(1) == 4;
            assert PT.Element(2) == 6;
            assert PT.Element(3) == 4;
            assert PT.Element(4) == 1;

            long [] row = PT.Row();
            assert row[2] == 6;
            assert row[4] == 1;
        }

        try
        {
            PascalsTriangle PT = new PascalsTriangle(-12);
            assert false;
        }
        catch(final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            PascalsTriangle PT = new PascalsTriangle(12);
            PT.Element(13);
            assert false;
        }
        catch(final IllegalArgumentException e)
        {
            assert true;
        }

        try
        {
            PascalsTriangle PT = new PascalsTriangle(30);
            PT.Element(-13);
            assert false;
        }
        catch(final IllegalArgumentException e)
        {
            assert true;
        }
    }

    public static void TestNewtonSymbol()
    {
        assert Math.NewtonSymbol(0, 0) == 1;
        assert Math.NewtonSymbol(4, 3) == 4;
        assert Math.NewtonSymbol(25, 7) == 480700;
        assert Math.NewtonSymbol(235, 8) == 204511270823145L;
    }
}