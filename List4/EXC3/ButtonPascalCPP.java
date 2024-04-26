import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.logging.Level;
import java.io.*;



public class ButtonPascalCPP extends Button
{
    public ButtonPascalCPP(final String name, final ComboBox<Integer> box, final TextField textArea, Label label, final String path)
    {
        super(name);

        setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent ae)
            {
                AppLogger.logger.log(Level.INFO, "Button clicked");

                if(box.getValue() == null)
                {
                    ErrorHandler.showError("Wrong value", "Please choose a value");
                    return;
                }

                final Integer n = box.getValue();
                final String[] args = textArea.getText().split(" ");

                List<String> command = new ArrayList<String>();
                command.addAll(Arrays.asList(args));
                command.addFirst(n.toString());
                command.addFirst(path);

                try
                {
                    ProcessBuilder processBuilder = new ProcessBuilder(command);
                    Process process = processBuilder.start();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String output = "";

                    String line;
                    while ((line = reader.readLine()) != null)
                    {
                        output += line + "\n";
                    }

                    label.setText(output);
                }
                catch(IOException e)
                {
                    AppLogger.logger.log(Level.SEVERE, "Error while accessing " + path, e);
                    ErrorHandler.showError("Process error", e.getMessage());
                }
            }
        });
    }
}
