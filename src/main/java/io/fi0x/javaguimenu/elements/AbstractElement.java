package io.fi0x.javaguimenu.elements;

import javafx.scene.Node;

public abstract class AbstractElement
{
    protected int colIdx = -1;
    protected int rowIdx = -1;
    protected int colSpan = 1;
    protected int rowSpan = 1;
    protected double xPos;
    protected double yPos;

    public abstract Node getNodeVersion();

    public void setColIdx(int columnIndex)
    {
        colIdx = columnIndex;
    }
    public int getColIdx()
    {
        return colIdx;
    }
    public void setRowIdx(int rowIndex)
    {
        rowIdx = rowIndex;
    }
    public int getRowIdx()
    {
        return rowIdx;
    }
    public void setColSpan(int columnSpan)
    {
        colSpan = columnSpan;
    }
    public int getColSpan()
    {
        return colSpan;
    }
    public void setRowSpan(int rowSpan)
    {
        this.rowSpan = rowSpan;
    }
    public int getRowSpan()
    {
        return rowSpan;
    }
    public void setXPos(double xPosition)
    {
        xPos = xPosition;
    }
    public double getXPos()
    {
        return xPos;
    }
    public void setYPos(double yPosition)
    {
        yPos = yPosition;
    }
    public double getYPos()
    {
        return yPos;
    }
}
