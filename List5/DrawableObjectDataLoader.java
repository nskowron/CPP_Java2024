import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for loading and saving DrawableObjectData objects.
 */
public class DrawableObjectDataLoader {

    /**
     * Loads DrawableObjectData objects from a file.
     * @param file The file to load the data from.
     * @return A list of DrawableObjectData objects loaded from the file.
     * @throws IOException If an I/O error occurs.
     * @throws ClassNotFoundException If the class of the serialized object cannot be found.
     * @throws ClassCastException If the object read from the file is not of the expected type.
     * @brief Loads DrawableObjectData objects from a file.
     */
    public List<DrawableObjectData> load(File file) throws IOException, ClassNotFoundException, ClassCastException {
        // Open input streams
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        // Read object from the input stream
        Object object = objectInputStream.readObject();

        // Close input streams
        objectInputStream.close();
        fileInputStream.close();

        // Check if the object is a list of DrawableObjectData
        if(object instanceof List) {
            List<?> objects = (List<?>) object;
            List<DrawableObjectData> data = new ArrayList<>(objects.size());

            // Convert each object to DrawableObjectData and add to the list
            for(Object _object : objects) {
                data.add((DrawableObjectData) _object);
            }

            return data;
        } else {
            throw new ClassCastException("Could not read correct data from file");
        }
    }

    /**
     * Saves a list of DrawableObjectData objects to a file.
     * @param data The list of DrawableObjectData objects to save.
     * @param file The file to save the data to.
     * @throws IOException If an I/O error occurs.
     * @throws FileNotFoundException If the specified file cannot be found.
     * @brief Saves a list of DrawableObjectData objects to a file.
     */
    public void save(List<DrawableObjectData> data, File file) throws IOException, FileNotFoundException {
        // Open output streams
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        // Write the list of DrawableObjectData objects to the output stream
        objectOutputStream.writeObject(data);

        // Close output streams
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
