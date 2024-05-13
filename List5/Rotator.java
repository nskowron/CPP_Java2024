import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class Rotator extends Group
{
    private Circle rotator;
    private Line line;

    public Rotator(String pathToIcon, double drawingShapeX, double drawingShapeY, double length, double radius)
    {
        line = new Line(drawingShapeX, drawingShapeY, drawingShapeX, drawingShapeY - length);
        rotator = new Circle(drawingShapeX, drawingShapeY - length, radius);

        line.setStroke(Color.BLUE);

        Image icon = new Image(getClass().getResourceAsStream(pathToIcon));
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(2 * radius);
        iconView.setFitHeight(2 * radius);
        //iconView.setClip(rotator);

        this.getChildren().addFirst(line);
        this.getChildren().addLast(rotator);
    }
}
