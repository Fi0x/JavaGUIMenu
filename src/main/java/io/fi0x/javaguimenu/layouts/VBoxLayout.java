package io.fi0x.javaguimenu.layouts;

import io.fi0x.javaguimenu.elements.AbstractElement;
import io.fi0x.javalogger.logging.Logger;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class creates a VBox layout where elements can be placed.
 * Rows are used to position elements, columns are ignored.
 * The x and y positions of elements set an offset from the default positions.
 */
public class VBoxLayout extends VBox
{
    private boolean spaceElementsEvenly = true;
    private ArrayList<AbstractElement> elements;
    private int nextRowIdx = 0;
    private int rowCount = 1;

    public VBoxLayout(Map<String, Object> userSettings)
    {
        AnchorPane.setTopAnchor(this, 0d);
        AnchorPane.setBottomAnchor(this, 0d);
        AnchorPane.setLeftAnchor(this, 0d);
        AnchorPane.setRightAnchor(this, 0d);

        setUserOptions(userSettings);
    }

    private void setUserOptions(Map<String, Object> settings)
    {
        Logger.log("VBox layout setup started", Logger.TEMPLATE.VERBOSE);
        for(Map.Entry<String, Object> entry : settings.entrySet())
        {
            switch(entry.getKey())
            {
                case "elementSpacing":
                    spaceElementsEvenly = (boolean) entry.getValue();
                    break;
                case "elements":
                    elements = (ArrayList<AbstractElement>) entry.getValue();
                    Logger.log("Loaded " + elements.size() + " elements from settings-map", Logger.TEMPLATE.VERBOSE);
                    break;
                case "rows":
                    rowCount = (int) entry.getValue();
                    break;
                default:
                    Logger.log("Invalid user-settings-entry in grid layout detected", Logger.TEMPLATE.INFO);
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
        Logger.log("Added " + elements.size() + " elements to layout", Logger.TEMPLATE.VERBOSE);
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
