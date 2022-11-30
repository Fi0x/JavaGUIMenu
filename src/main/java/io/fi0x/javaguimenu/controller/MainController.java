package io.fi0x.javaguimenu.controller;

import io.fi0x.javaguimenu.layouts.*;
import io.fi0x.javalogger.logging.Logger;
import javafx.fxml.FXML;
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
        LayoutTypes layout = (LayoutTypes) settings.get("layout");
        if(layout == null)
        {
            Logger.log("No layout type found", Logger.TEMPLATE.WARNING);
            return;
        }

        settings.remove("layout");
        setLayout(layout, settings);

        Logger.log("Main controller initialized", Logger.TEMPLATE.VERBOSE);
    }

    private void setLayout(LayoutTypes type, Map<String, Object> settings)
    {
        switch(type)
        {
            case Grid:
                Logger.log("Using Grid layout", Logger.TEMPLATE.VERBOSE);
                apMain.getChildren().add(new GridLayout(settings));
                break;
            case VBox:
                Logger.log("Using VBox layout", Logger.TEMPLATE.VERBOSE);
                settings.remove("columns");
                apMain.getChildren().add(new VBoxLayout(settings));
                break;
            case HBox:
                Logger.log("Using HBox layout", Logger.TEMPLATE.VERBOSE);
                settings.remove("rows");
                apMain.getChildren().add(new HBoxLayout(settings));
                break;
            case Absolute:
                Logger.log("Using Absolute layout", Logger.TEMPLATE.VERBOSE);
                settings.remove("elementSpacing");
                settings.remove("rows");
                settings.remove("columns");
                apMain.getChildren().add(new AbsoluteLayout(settings));
                break;
            default:
                Logger.log("The selected layout is not valid", Logger.TEMPLATE.WARNING);
                break;
        }
    }
}
