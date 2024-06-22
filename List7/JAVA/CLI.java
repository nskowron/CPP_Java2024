public class CLI<T extends Comparable<T>>
{
    private BST<T> tree;
    private Parser<T> parser;

    public CLI(Parser<T> parser)
    {
        this.parser = parser;
        tree = new BST<>();
    }

    public void run()
    {
        while(true)
        {
            String input = IO.getInputLine();
            if(input.isEmpty() || input == null)
            {
                continue;
            }

            String[] command = input.split("\\s+");
            switch(command[0].toLowerCase())
            {
                case "draw":
                case "print":
                case "p":

                case "add":
                case "insert":
                case "a":
                case "i":

                case "delete":
                case "remove":
                case "d":
                case "r":

                case "search":
                case "find":
                case "s":
                case "f":

                default:
                    IO.setOutputLine("Invalid command: " + command[0]);
            }
        }
    }
}
