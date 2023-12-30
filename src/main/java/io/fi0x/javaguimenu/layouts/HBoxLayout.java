package io.fi0x.javaguimenu.layouts;

import io.fi0x.javaguimenu.elements.AbstractElement;
import io.fi0x.javalogger.logging.LOG;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class creates a HBox layout where elements can be placed.
 * Columns are used to position elements, rows are ignored.
 * The x and y positions of elements set an offset from the default positions.
 */
public class HBoxLayout extends HBox
{
    private boolean spaceElementsEvenly = true;
    private ArrayList<AbstractElement> elements;
    private int nextColIdx = 0;
    private int colCount = 1;


    /**
     * The main constructor of this method.
     *
     * @param userSettings The user-settings that should be used for this h-box.
     */
    public HBoxLayout(Map<String, Object> userSettings)
    {
        AnchorPane.setTopAnchor(this, 0d);
        AnchorPane.setBottomAnchor(this, 0d);
        AnchorPane.setLeftAnchor(this, 0d);
        AnchorPane.setRightAnchor(this, 0d);

        setUserOptions(userSettings);
    }

    private void setUserOptions(Map<String, Object> settings)
    {
        for(Map.Entry<String, Object> entry : settings.entrySet())
        {
            switch(entry.getKey())
            {
                case "elementSpacing" -> spaceElementsEvenly = (boolean) entry.getValue();
                case "elements" -> elements = (ArrayList<AbstractElement>) entry.getValue();
                case "columns" -> colCount = (int) entry.getValue();
                default -> LOG.WARN("Invalid user-settings-entry in h-box layout detected", "JavaGUIMenu", 610);
            }
        }
        addAllElements();
    }

    private void addAllElements()
    {
        for(AbstractElement e : elements)
        {
            refineElementValues(e);
            this.getChildren().add(e.getColIdx(), e.getNodeVersion());
        }
    }
    private void refineElementValues(AbstractElement element)
    {
        if(spaceElementsEvenly)
        {
            if(nextColIdx >= colCount)
                nextColIdx = 0;

            element.setColIdx(nextColIdx);
            nextColIdx++;
        }
        else
        {
            if(element.getColIdx() < 0)
                element.setColIdx(0);
        }
    }
}
