public final class Main
{
    public static void main(final String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("Not enough arguments");
            return;
        }

        PascalsTriangle PM;
        try
        {
            int n = Integer.parseInt(args[0]);
            PM = new PascalsTriangle(n);
        }
        catch(final NumberFormatException e)
        {
            System.out.println();
        }
    }
}
