public class Drawer
{
    private Drawable drawingTemplate;
    private Canvas canvas;
    
    public Drawer(Canvas canvas)
    {
        drawingTemplate = null;
        this.canvas = canvas;
    }

    public Drawable draw(double x, double y)
    {
        Drawable drawnObject = drawingTemplate.clone();

        drawnObject.setTranslateX(x);
        drawnObject.setTranslateY(y);

        //add paint
        
        drawnObject.draw(canvas);
        return drawnObject;
    }

    public void setTemplate(Drawable object)
    {
        drawingTemplate = object;
    }
}
