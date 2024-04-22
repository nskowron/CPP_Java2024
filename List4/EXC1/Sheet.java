import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;

import java.util.logging.Level;

public class Sheet extends GridPane
{
    public Sheet(int x, int y) throws IllegalArgumentException
    {
        if(x < 0 || y < 0)
        {
            throw new IllegalArgumentException("Sheet cannot have negative number of columns / rows, got: " + x + " / " + y);
        }

        for(int i = 0; i < x; ++i)
        {
            for(int j = 0; j < y; ++j)
            {
                Label label = new Label();
                add(label, i, j);
            }
        }

        AppLogger.logger.log(Level.INFO, "Sheet has been initiated");
    }

    public Label Get(int x, int y) throws IndexOutOfBoundsException
    {
        if(x < 0 || y < 0)
        {
            throw new IndexOutOfBoundsException("Index cannot be negative, got: " + x + ", " + y);
        }
        if(x >= getColumnCount())
        {
            throw new IndexOutOfBoundsException("Index out of range, x: " + x + " >= " + getColumnCount());
        }
        if(x >= getRowCount())
        {
            throw new IndexOutOfBoundsException("Index out of range, y: " + y + " >= " + getRowCount());
        }

        return (Label) getChildren().get(y * getColumnCount() + x);
    }

    public void Clear()
    {
        for(Node node : getChildrenUnmodifiable())
        {
            ((Label)node).setText("");
        }
    }
}
