package io.fi0x.javaguimenu.controller;

import io.fi0x.javaguimenu.layouts.*;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lombok.extern.java.Log;

import java.util.Map;

/**
 * This class controls the GUI.
 */
@Log
public class MainController
{
    /**
     * This pane is the anchor-pane of the GUI where all other elements get added.
     */
    @FXML
    public AnchorPane apMain;

    /**
     * Default constructor of this class.
     */
    public MainController()
    {
    }

    @FXML
    private void initialize()
    {
    }

    /**
     * This method lets the user add individual options for the layout.
     *
     * @param settings The settings that should be integrated into the layout.
     */
    public void setUserOptions(Map<String, Object> settings)
    {
        LayoutTypes layout = (LayoutTypes) settings.get("layout");
        if(layout == null)
        {
            log.warning("No layout type found");
            return;
        }

        settings.remove("layout");
        setLayout(layout, settings);
    }

    private void setLayout(LayoutTypes type, Map<String, Object> settings)
    {
        switch(type)
        {
            case Grid -> apMain.getChildren().add(new GridLayout(settings));
            case VBox ->
            {
                settings.remove("columns");
                apMain.getChildren().add(new VBoxLayout(settings));
            }
            case HBox ->
            {
                settings.remove("rows");
                apMain.getChildren().add(new HBoxLayout(settings));
            }
            case Absolute ->
            {
                settings.remove("elementSpacing");
                settings.remove("rows");
                settings.remove("columns");
                apMain.getChildren().add(new AbsoluteLayout(settings));
            }
            default -> log.warning("The selected layout is not valid");
        }
    }
}
