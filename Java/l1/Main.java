public final class Main 
{ 
    public static void main(final String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("Not enough arguments");
            return;
        }

        Primes PRIMELIST;
        int n;

        try
        {
            n = Integer.parseInt(args[0]);
            PRIMELIST = new Primes(n);
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
                System.out.println("For: " + PRIMELIST.get(Integer.parseInt(args[i])-1) + " is the " + args[i] + "th prime < " + n); // nr rzędu, element tego rzędu , numer tego elementu
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
