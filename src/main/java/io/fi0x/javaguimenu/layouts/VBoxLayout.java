package io.fi0x.javaguimenu.layouts;

import io.fi0x.javaguimenu.elements.AbstractElement;
import io.fi0x.javalogger.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Map;

public class VBoxLayout extends VBox
{
    private final Map<String, Object> settings;
    private boolean spaceElementsEvenly = true;
    private ArrayList<AbstractElement> elements;
    private int nextRowIdx = 0;
    private int rowCount = 1;

    public VBoxLayout(Map<String, Object> userSettings)
    {
        settings = userSettings;
    }

    @FXML
    private void initialize()
    {
        setUserOptions(settings);
    }

    private void setUserOptions(Map<String, Object> settings)
    {
        for(Map.Entry<String, Object> entry : settings.entrySet())
        {
            switch(entry.getKey())
            {
                case "elementSpacing":
                    spaceElementsEvenly = (boolean) entry.getValue();
                    break;
                case "elements":
                    elements = (ArrayList<AbstractElement>) entry.getValue();
                    break;
                case "rows":
                    rowCount = (int) entry.getValue();
                    break;
                default:
                    Logger.log("Invalid user-settings-entry in grid layout detected", "info");
            }
        }
        addAllElements();
    }

    private void addAllElements()
    {
        for(AbstractElement e : elements)
        {
            refineElementValues(e);
            this.getChildren().add(e.getRowIdx(), e.getNodeVersion());
        }
    }
    private void refineElementValues(AbstractElement element)
    {
        if(spaceElementsEvenly)
        {
            if(nextRowIdx >= rowCount)
                nextRowIdx = 0;

            element.setRowIdx(nextRowIdx);
            nextRowIdx++;
        }
        else
        {
            if(element.getRowIdx() < 0)
                element.setRowIdx(0);
        }
    }
}
