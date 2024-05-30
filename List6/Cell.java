import java.util.logging.Level;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle implements Runnable
{
    private static final Randomiser random = new Randomiser();

    private final long sleepTime;
    private final double randomColorProbability;

    private final Thread thread;
    private Cell[] neighbors;
    private boolean active;

    private boolean running;

    public Cell(long sleepTime, double randomColorProbability) throws IllegalArgumentException
    {
        super(30, 30, random.nextColor());

        if(sleepTime <= 0)
        {
            throw new IllegalArgumentException("Cell sleep time must be positive, got: " + sleepTime);
        }
        if(randomColorProbability < 0)
        {
            throw new IllegalArgumentException("Cell probability cannot be negative, got: " + randomColorProbability);
        }

        this.sleepTime = sleepTime;
        this.randomColorProbability = randomColorProbability;

        thread = new Thread(this);
        neighbors = null;
        active = false;

        running = true;

        thread.start();
    }

    public void setup(Cell[] neighbors)
    {
        this.neighbors = neighbors;
        active = true;
        
        this.setOnMouseClicked(me ->
        {
            active = !active;
            Logger.logger.log(Level.INFO, "Cell clicked");
        });
    }

    public void stopThread()
    {
        running = false;
    }

    public boolean isActive()
    {
        return active;
    }

    @Override
    public void run()
    {
        while(running)
        {
            try
            {
                Thread.sleep(random.nextLong(sleepTime) + (int)(sleepTime * 0.5));
            }
            catch(InterruptedException e)
            {
                ErrorHandler.showError("Thread Interruption error", "Thread nr " + thread.threadId() + " has been interrupted.");
            }

            if(active)
            {
                Platform.runLater(() ->
                {
                    ThreadLogger.logStart(thread);

                    if(random.nextDouble(100.0 + Math.ulp(100.0d)) <= randomColorProbability)
                    {
                        setFill(random.nextColor());
                    }
                    else
                    {
                        double avgRed = 0;
                        double avgGreen = 0;
                        double avgBlue = 0;
                        int count = 0;

                        for(Cell neighbor : neighbors)
                        {
                            if(neighbor != null && neighbor.isActive())
                            {
                                try
                                {
                                    Color neighborColor = (Color)neighbor.getFill();
                                    avgRed += neighborColor.getRed();
                                    avgGreen += neighborColor.getGreen();
                                    avgBlue += neighborColor.getBlue();
                                    ++count;
                                }
                                catch(ClassCastException e)
                                {
                                    ErrorHandler.showError("Data reading error", "Could not read Cell color in thread nr " + Thread.currentThread().threadId());
                                }
                            }
                        }

                        if(count != 0)
                        {
                            setFill(new Color(avgRed / count, avgGreen / count, avgBlue / count, 1.0));
                        }
                    }

                    ThreadLogger.logEnd(thread);
                });
            }
        }
    }

    
}
