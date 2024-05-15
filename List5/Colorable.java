import javafx.scene.paint.Paint;

public interface Colorable
{
    public Paint getFill();

    public Paint getStroke();
    public double getStrokeWidth();


    public void setFill(Paint paint);

    public void setStroke(Paint paint);
    public void setStrokeWidth(double width);
}
