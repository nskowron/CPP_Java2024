public class DeleteButton extends PopupEditButton
{
    public DeleteButton(Drawable object)
    {
        super("delete");

        setOnAction(event ->
        {
            object.delete();
        });
    }
}
