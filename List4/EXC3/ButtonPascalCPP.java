import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.logging.Level;


public class ButtonPascalCPP extends Button
{
    public ButtonPascalCPP(String name, ComboBox<Integer> box, TextArea textArea, Label label)
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

                Integer n = box.getValue();
                ProcessBuilder processBuilder = new ProcessBuilder("../PascalCPP/main.exe", n.toString(), textArea.getText());
                Process process = processBuilder.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder output = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null)
                {
                    output.append(line).append("\n");
                }

                label.setText(output);

                AppLogger.logger.log(Level.INFO, "Triangle generated");
            }
        });
    }
}
