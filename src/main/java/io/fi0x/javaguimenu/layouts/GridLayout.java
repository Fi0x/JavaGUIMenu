package io.fi0x.javaguimenu.layouts;

import io.fi0x.javalogger.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

import java.util.Map;

public class GridLayout extends GridPane
{
    @FXML
    private void initialize()
    {
    }

    public void setUserOptions(Map<String, String> settings)
    {
        for(Map.Entry<String, String> entry : settings.entrySet())
        {
            switch(entry.getKey())
            {
                case "layout":
                    break;
                case "element":
                    //TODO: Add UI elements that user selects here
                    break;
                default:
                    Logger.log("Unknown entry in user settings detected", "info");
            }
        }
    }
}
