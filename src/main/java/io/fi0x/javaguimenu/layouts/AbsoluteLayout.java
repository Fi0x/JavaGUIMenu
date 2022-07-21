package io.fi0x.javaguimenu.layouts;

import io.fi0x.javaguimenu.elements.AbstractElement;
import io.fi0x.javalogger.logging.Logger;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class creates an Absolute layout where elements can be placed.
 * Columns and rows are ignored and only the x and y positions of elements
 * are used to set the location.
 */
public class AbsoluteLayout extends Pane
{
    private ArrayList<AbstractElement> elements;

    public AbsoluteLayout(Map<String, Object> userSettings)
    {
        AnchorPane.setTopAnchor(this, 0d);
        AnchorPane.setBottomAnchor(this, 0d);
        AnchorPane.setLeftAnchor(this, 0d);
        AnchorPane.setRightAnchor(this, 0d);

        setUserOptions(userSettings);
    }

    private void setUserOptions(Map<String, Object> settings)
    {
        Logger.log("Absolute layout setup started", "verbose");
        for(Map.Entry<String, Object> entry : settings.entrySet())
        {
            if("elements".equals(entry.getKey()))
                elements = (ArrayList<AbstractElement>) entry.getValue();
            else
                Logger.log("Invalid user-settings-entry in grid layout detected", "info");
        }
        addAllElements();
    }

    private void addAllElements()
    {
        for(AbstractElement e : elements)
        {
            Node n = e.getNodeVersion();
            n.setTranslateX(e.getXPos());
            n.setTranslateY(e.getYPos());
            this.getChildren().add(n);
        }
        Logger.log("Added " + elements.size() + " elements to layout", "verbose");
    }
}
