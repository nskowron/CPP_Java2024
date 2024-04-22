import java.util.ConcurrentModificationException;
import java.util.logging.Level;

import javafx.scene.Node;

public class ColorChanger extends Thread
{
    private Node node;
    private boolean running;

    public ColorChanger(Node node)
    {
        this.node = node;
        this.running = false;
    }

    @Override
    public void run()
    {
        running = true;

        AppLogger.logger.log(Level.INFO, "Thread started");

        int gradient = 0;
        int gradChange = 15;
        while(running)
        {
            if(gradient == 0)
            {
                gradChange = 15;
            }
            if(gradient == 255)
            {
                gradChange = -15;
            }

            String color = String.format("#%02X%02X%02X", 255 - gradient, 0, gradient);

            try
            {
                node.setStyle("-fx-background-color: " + color);
            }
            catch(ConcurrentModificationException e) {}

            gradient += gradChange;

            try
            {
                Thread.sleep(50);
            }
            catch(InterruptedException e)
            {
                ErrorHandler.showError("Thread", "Thread interrupted");
            }
        }
    }

    public void terminate()
    {
        running = false;
    }
}
