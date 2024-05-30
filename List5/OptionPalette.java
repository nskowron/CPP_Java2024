import javafx.scene.layout.GridPane;

/**
 * @brief A palette for organizing OptionButtons in a grid layout.
 * 
 * This class represents a palette for organizing OptionButtons in a grid layout.
 * OptionButtons can be added to the palette, and they will be automatically 
 * positioned in a grid based on the order of insertion.
 */
public class OptionPalette extends GridPane {

    private int size; // Number of buttons in the palette

    /**
     * @brief Constructor for OptionPalette.
     * 
     * Constructs an empty OptionPalette.
     */
    public OptionPalette() {
        size = 0; // Initialize the size to 0
    }

    /**
     * @brief Adds an OptionButton to the palette.
     * 
     * Adds the specified OptionButton to the palette at the next available position
     * in the grid layout. The position is determined based on the order of insertion.
     * 
     * @param button The OptionButton to add to the palette.
     */
    public void add(OptionButton button) {
        // Add the button to the next available position in the grid
        add(button, size, 0);
        // Increment the size to reflect the addition of the button
        ++size;
    }
}
