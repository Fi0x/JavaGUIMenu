package io.fi0x.javaguimenu.controller;

import io.fi0x.javaguimenu.layouts.LayoutTypes;
import io.fi0x.javalogger.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.util.Map;

public class MainController
{
    @FXML
    public AnchorPane apMain;

    @FXML
    private void initialize()
    {
    }

    public void setUserOptions(Map<String, Object> settings)
    {
        for(Map.Entry<String, Object> entry : settings.entrySet())
        {
            switch(entry.getKey())
            {
                case "layout":
                    setLayout(LayoutTypes.valueOf((String) entry.getValue()));
                    break;
                default:
                    Logger.log("Unknown entry in user settings detected", "info");
            }
        }
    }

    private void setLayout(LayoutTypes type)
    {
        apMain.getChildren().add(new Button());
        //TODO: Anchor correct layout to main pane
        //TODO: Add UI elements that user selects here
    }
}
