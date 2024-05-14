import java.io.Serializable;

public interface Drawable extends Serializable, Transformable, Colorable
{
    public void draw(Canvas canvas);
    public void redraw();
    public void delete();

    public DrawableObjectData getData();
}
