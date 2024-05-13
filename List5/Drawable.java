import java.io.Serializable;

public interface Drawable extends Serializable, Transformable, Colorable
{
    public void draw(Canvas canvas);
    public void delete();

    public Drawable clone();
}
