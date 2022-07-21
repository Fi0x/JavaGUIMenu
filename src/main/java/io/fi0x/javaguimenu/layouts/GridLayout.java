package io.fi0x.javaguimenu.layouts;

import io.fi0x.javaguimenu.elements.AbstractElement;
import io.fi0x.javalogger.logging.Logger;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Map;

public class GridLayout extends GridPane
{
    private boolean spaceElementsEvenly = true;
    private ArrayList<AbstractElement> elements;
    private int nextColIdx = 0;
    private int nextRowIdx = 0;

    private int colCount = 1;
    private int rowCount = 1;

    public GridLayout(Map<String, Object> userSettings)
    {
        setUserOptions(userSettings);
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
                case "columns":
                    colCount = (int) entry.getValue();
                    break;
                case "rows":
                    rowCount = (int) entry.getValue();
                    break;
                case "width":
                    break;
                case "height":
                    break;
                default:
                    Logger.log("Invalid user-settings-entry in grid layout detected", "info");
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
            nextRowIdx++;
        }
        else
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

        AnchorPane.setTopAnchor(this, 0d);
        AnchorPane.setBottomAnchor(this, 0d);
        AnchorPane.setLeftAnchor(this, 0d);
        AnchorPane.setRightAnchor(this, 0d);
    }
}
