import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Node;

//add indication that a utton is pressed
public abstract class OptionButton extends Button
{
    public OptionButton(String pathToIcon)
    {
        double x = 30;
        double y = 25;
        
        //add checking if file exists
        Image icon = new Image(getClass().getResourceAsStream(pathToIcon));
        ImageView iconView = new ImageView(icon);
        iconView.setFitWidth(x);
        iconView.setFitHeight(y);

        this.setGraphic(iconView);

        setMinHeight(y);
        setMinWidth(x);
        setMaxHeight(y);
        setMaxWidth(x);

        setHeight(y);
        setWidth(x);
    }

    // public abstract void EndAction();

    // protected abstract class ActionEventHandler implements EventHandler<ActionEvent>
    // {
    //     @Override
    //     public void handle(ActionEvent me)
    //     {
    //         for(Node node : optionPalette.getChildren())
    //         {
    //             ((OptionButton)node).EndAction();
    //         }
    //     }
    // }
}
