public class Main
{
    public static void main(String[] args)
    {
        IO.setOutputLine("Enter Tree type:"); 
        IO.setOutputLine("[i]nteger, [d]ouble, [s]tring");
        String input = IO.getInputLine().toLowerCase();
        switch(input)
        {
            case "integer":
            case "int":
            case "i":
                CLI<Integer> integerCLI = new CLI<Integer>(new Parser<Integer>()
                {
                    @Override
                    public Integer parse(String s)
                    {
                        return Integer.parseInt(s);
                    }
                });
                integerCLI.run();
                break;

            case "float":
            case "double":
            case "d":
                CLI<Double> doubleCLI = new CLI<Double>(new Parser<Double>()
                {
                    @Override
                    public Double parse(String s)
                    {
                        return Double.parseDouble(s);
                    }
                });
                doubleCLI.run();
                break;

            case "text":
            case "string":
            case "s":
                CLI<String> stringCLI = new CLI<String>(new Parser<String>()
                {
                    @Override
                    public String parse(String s)
                    {
                        return s;
                    }
                });
                stringCLI.run();
                break;

            default:
                IO.setOutputLine("Invalid Tree type.");
        }
    }
}