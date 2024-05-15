import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
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
        Map<String, DrawableObjectSupplier> handledObjects = new HashMap<>(0);
        handledObjects.put("Ellipse", new EllipseSupplier());
        handledObjects.put("Triangle", new TriangleSupplier());
        handledObjects.put("Rectangle", new RectangleSupplier());

        new PaintGUI(stage, handledObjects);
    }
}