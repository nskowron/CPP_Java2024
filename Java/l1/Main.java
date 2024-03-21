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
        
            System.out.println("\n");

        for(int i = 1; i < args.length; i++)
        {   
            try
            {
                System.out.println("For: " + PRIMELIST.get(Integer.parseInt(args[i])-1) + " is the " + args[i] + "th prime < " + n);
            }
            catch(final Exception e)
            {
                System.out.println(args[i]+ " :: " + e.getStackTrace()[e.getStackTrace().length-1]+ /*" :: " + e.getCause() +*/ " :: " + e.getMessage()); // jeszcze raz, czemu getstacktrace ma "[]" ?
            }
        }
        }
        catch(final Exception e)
        {
            System.out.println(args[0]+ " :: " + e.getStackTrace()[e.getStackTrace().length-1]+ /*" :: " + e.getCause() +*/ " :: " + e.getMessage()); 
        }
    }
}
