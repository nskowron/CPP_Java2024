/**
 * Represents a button used for deleting a drawable object.
 * Extends PopupEditButton.
 */
public class DeleteButton extends PopupEditButton {

    /**
     * Constructs a new DeleteButton object.
     * @param object The drawable object to be deleted.
     * @brief Constructs a new DeleteButton object for deleting a drawable object.
     */
    public DeleteButton(Drawable object) {
        super("delete"); // Call constructor of superclass PopupEditButton with label "delete"

        // Set action to delete the object when the button is clicked
        setOnAction(event -> {
            object.delete(); // Call delete method of the drawable object
        });
    }
}
