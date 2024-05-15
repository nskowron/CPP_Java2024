public interface Drawable extends Transformable, Colorable, Controllable
{
    public void draw(Canvas canvas);
    public void redraw();
    public void delete();

    public DrawableObjectData getData();
}
