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
    public List<DrawableObjectData> load(File file) throws IOException, FileNotFoundException, ClassNotFoundException
    {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<DrawableObjectData> datas = new ArrayList<>(0);
        try
        {
            while(true)
            {
                DrawableObjectData data = (DrawableObjectData)objectInputStream.readObject();
                datas.add(data);
            }
        }
        catch(EOFException eof)
        {
            PaintLogger.logger.log(Level.INFO, "Object data loaded");
        }

        objectInputStream.close();
        fileInputStream.close();

        return datas;
    }

    public void save(List<DrawableObjectData> datas, File file) throws IOException, FileNotFoundException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for(DrawableObjectData data : datas)
        {
            objectOutputStream.writeObject(data);
        }

        objectOutputStream.close();
        fileOutputStream.close();
    }
}
