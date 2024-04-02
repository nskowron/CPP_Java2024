public final class Main
{
    public static void main(String[] args)
    {
        if(args.length < 2)
        {
            System.out.println("Not enough arguments");
            return;
        }

        // One-Param shapes
        try
        {
            Shapes.Shape_OneParam shape = ShapesInstantiator.CreateShape_OneParam(args[0]);
            try
            {
                if(args.length != 2)
                {
                    throw new IllegalArgumentException("Wrong number of arguments for a one-parameter shape. Should be 1, got: " + (args.length - 1));
                }
                double param1 = Double.parseDouble(args[1]);
                System.out.println(shape.Name() + ":\nArea - " + shape.Area(param1) + "\nCircumference - " + shape.Circumference(param1));
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }
        }
        catch(IllegalArgumentException f)
        {
            try
            {
                Shapes.Shape_TwoParam shape = ShapesInstantiator.CreateShape_TwoParam(args[0]);
                if(args.length != 3)
                {
                    throw new IllegalArgumentException("Wrong number of arguments for a two-parameter shape. Should be 2, got: " + (args.length - 1));
                }
                double param1 = Double.parseDouble(args[1]);
                double param2 = Double.parseDouble(args[2]);
                System.out.println(shape.Name() + ":\nArea - " + shape.Area(param1, param2) + "\nCircumference - " + shape.Circumference(param1, param2));
            }
            catch(IllegalArgumentException e)
            {
                e.printStackTrace();
            }
        }
    }
}

//o - circle, s - square, p - pentagon, h - hexagon, re - rectangle, rh - rhombus