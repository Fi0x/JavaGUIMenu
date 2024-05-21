package io.fi0x.javaguimenu.layouts;

import io.fi0x.javaguimenu.elements.AbstractElement;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Map;

/**
 * This class creates a Grid layout where elements can be placed.
 * Columns and rows are used to position elements
 * and the x and y positions of elements set an offset from the default positions.
 */
@Log
public class GridLayout extends GridPane
{
    private boolean spaceElementsEvenly = true;
    private ArrayList<AbstractElement> elements;
    private int nextColIdx = 0;
    private int nextRowIdx = 0;

    private int colCount = 1;
    private int rowCount = 1;
    private boolean gridLaneVisibility = false;

    /**
     * Main constructor of this class.
     *
     * @param userSettings The user-settings that should be used for this layout.
     */
    public GridLayout(Map<String, Object> userSettings)
    {
        AnchorPane.setTopAnchor(this, 0d);
        AnchorPane.setBottomAnchor(this, 0d);
        AnchorPane.setLeftAnchor(this, 0d);
        AnchorPane.setRightAnchor(this, 0d);

        setUserOptions(userSettings);

        this.setGridLinesVisible(gridLaneVisibility);
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
                case "rows" -> rowCount = (int) entry.getValue();
                case "gridLanes" -> gridLaneVisibility = (boolean) entry.getValue();
                default -> log.warning("Invalid user-settings-entry in grid layout detected");
            }
        }
        setConstraints();
        addAllElements();
    }

    private void addAllElements()
    {
        for(AbstractElement e : elements)
        {
            refineElementValues(e);
            this.add(e.getNodeVersion(), e.getColIdx(), e.getRowIdx(), e.getColSpan(), e.getRowSpan());
        }
    }
    private void refineElementValues(AbstractElement element)
    {
        if(spaceElementsEvenly)
        {
            if(nextColIdx >= colCount)
            {
                nextColIdx = 0;
                nextRowIdx++;
            }
            if(nextRowIdx >= rowCount)
                nextRowIdx = 0;

            element.setColIdx(nextColIdx);
            element.setRowIdx(nextRowIdx);

            nextColIdx++;
        } else
        {
            if(element.getColIdx() < 0)
                element.setColIdx(0);
            if(element.getRowIdx() < 0)
                element.setRowIdx(0);
        }
    }

    private void setConstraints()
    {
        this.getColumnConstraints().clear();
        for(int i = 0; i < colCount; i++)
        {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setPercentWidth(100d / colCount);
            cc.setHgrow(Priority.ALWAYS);
            cc.setHalignment(HPos.CENTER);
            cc.setFillWidth(true);
            this.getColumnConstraints().add(cc);
        }

        this.getRowConstraints().clear();
        for(int i = 0; i < rowCount; i++)
        {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(100d / rowCount);
            rc.setVgrow(Priority.ALWAYS);
            rc.setValignment(VPos.CENTER);
            rc.setFillHeight(true);
            this.getRowConstraints().add(rc);
        }
    }
}
