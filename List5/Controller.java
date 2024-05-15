import javafx.event.*;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Controller
{
    private Mode mode;
    private Canvas canvas;
    private EventHandler<Event> filter;
    private Drawable primarilyClicked;

    public Controller(Pane root, Canvas canvas, Selector selector, Drawer drawer, ColorPicker colorPicker)
    {
        filter = e -> {};

        Mode.setDrawer(drawer);
        this.canvas = canvas;
        canvas.addController(this);

        this.setMode(Mode.SELECT);

        canvas.setOnMouseDragged(me ->
        {
            if(me.isPrimaryButtonDown() && selector.getSelected() != null)
            {
                selector.getSelected().setTranslateX(me.getX());
                selector.getSelected().setTranslateY(me.getY());
            }
        });

        canvas.setOnMousePressed(me ->
        {
            if(primarilyClicked != null)
            {
                selector.select(primarilyClicked);

                if(me.isSecondaryButtonDown())
                {
                    Button editMenuButtons[] = {new FillButton(primarilyClicked, colorPicker), new DeleteButton(primarilyClicked)};
                    PopupEditMenu editMenu = new PopupEditMenu(me.getX(), me.getY(), editMenuButtons);

                    //to root or to canvas?
                    root.getChildren().addLast(editMenu);
                    root.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
                    {
                        @Override
                        public void handle(MouseEvent me)
                        {
                            root.getChildren().remove(editMenu);
                            root.removeEventFilter(MouseEvent.MOUSE_PRESSED, this);
                        }
                    });
                }
            }
            else
            {
                selector.unselect();
            }
        });

        canvas.setOnMouseReleased(me ->
        {
            primarilyClicked = null;
        });

        canvas.setOnScroll(se ->
        {
            Drawable selected = selector.getSelected();
            if(selected != null)
            {
                if(se.isControlDown())
                {
                    selected.setRotate(selected.getRotate() + (Math.PI * 0.05 * se.getDeltaY()));
                }
                else
                {
                    selected.setWidth(selected.getWidth() * (1 + 0.003 * se.getDeltaY()));
                    selected.setHeight(selected.getHeight() * (1 + 0.003 * se.getDeltaY()));
                }
            }
        });
    }

    public void setMode(Mode newMode)
    {
        canvas.removeEventFilter(EventType.ROOT, filter);

        mode = newMode;
        filter = mode.getEventFilter();
        canvas.addEventFilter(EventType.ROOT, filter);
    }

    public void addControllable(Drawable object)
    {
        object.setOnMousePressed(me -> 
        {
            if(primarilyClicked == null)
            {
                primarilyClicked = object;
            }
        });
    }

    public void removeControllable(Drawable object)
    {
        object.setOnMousePressed(null);
    }
}
