import javafx.scene.control.Alert;

public class InfoDisplayer
{
    private InfoDisplayer() throws InstantiationError
    {
        throw new InstantiationError("Cannot create instance of a static class InfoDisplayer");
    }

    public static void display(String title, String info)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(info);
        alert.showAndWait();
    }
}
