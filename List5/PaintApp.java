import javafx.application.Application;
import javafx.stage.Stage;

import java.util.logging.Level;

public final class PaintApp extends Application
{
    public static void main(String[] args)
    {
        PaintLogger.Config();
        PaintLogger.logger.log(Level.INFO, "Paint created, logger initialised");

        Application.launch(args);
    }

    @Override
    public void start(Stage stage)
    {
        new PaintGUI(stage);
    }
}