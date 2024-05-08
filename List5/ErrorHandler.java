import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ErrorHandler 
{
    private ErrorHandler()
    {
        throw new InstantiationError("Cannot create instance of static class ErrorHandler");
    }

    public static void showError(String title, String message) 
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
