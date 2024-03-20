public final class Main
{ 
    public static void main(final String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("Not enough arguments");
            return;
        }

        PascalsTriangle PT;
        int n;

        try
        {
            n = Integer.parseInt(args[0]);
            PT = new PascalsTriangle(n);
        }
        catch(final NumberFormatException e)
        {
            System.out.println(args[0] + " : Not a valid entry");
            return;
        }
        
        System.out.println("\n");

        for(int i = 1; i < args.length; i++)
        {   
            try
            {
                System.out.println(n + ":row " + PT.Element(Integer.parseInt(args[i])) + ":row element " + args[i] + ":element id " ); // nr rzędu, element tego rzędu , numer tego elementu
            }
            catch(final NumberFormatException e)
            {
                System.out.println(args[i] + " : Not a valid entry");
            }
            catch(final IllegalArgumentException e)
            {
                System.out.println(args[i] + " : Not a valid number");
            }
        }
    }
}
