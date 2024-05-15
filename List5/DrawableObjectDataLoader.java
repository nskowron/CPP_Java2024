import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class DrawableObjectDataLoader
{
    public List<DrawableObjectData> load(File file) throws IOException, ClassNotFoundException, ClassCastException
    {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<DrawableObjectData> data = (List<DrawableObjectData>)objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        return data;
    }

    public void save(List<DrawableObjectData> data, File file) throws IOException, FileNotFoundException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(data);

        objectOutputStream.close();
        fileOutputStream.close();
    }
}
