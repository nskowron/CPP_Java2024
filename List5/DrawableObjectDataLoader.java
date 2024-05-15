import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DrawableObjectDataLoader
{
    public List<DrawableObjectData> load(File file) throws IOException, ClassNotFoundException, ClassCastException
    {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object = objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        if(object instanceof List)
        {
            List<?> objects = (List<?>)object;
            List<DrawableObjectData> data = new ArrayList<>(0);

            for(Object _object : objects)
            {
                data.add((DrawableObjectData)_object);
            }

            return data;
        }
        else
        {
            throw new ClassCastException("Could not read correct data from file");
        }
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
