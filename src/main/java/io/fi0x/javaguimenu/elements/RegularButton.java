package io.fi0x.javaguimenu.elements;

import javafx.scene.control.Button;

public class RegularButton extends Button implements Element
{
    private int colIdx = -1;
    private int rowIdx = -1;
    private int colSpan = 1;
    private int rowSpan = 1;
    private int xPos;
    private int yPos;
    public static RegularButton create(int columnIndex, int rowIndex, int columnSpan, int rowSpan)
    {
        return new RegularButton();
    }
    @Override
    public String getTypeName()
    {
        return this.getClass().getName();
    }
    @Override
    public void setColIdx(int columnIndex)
    {
        colIdx = columnIndex;
    }
    @Override
    public int getColIdx()
    {
        return colIdx;
    }
    @Override
    public void setRowIdx(int rowIndex)
    {
        rowIdx = rowIndex;
    }
    @Override
    public int getRowIdx()
    {
        return rowIdx;
    }
    @Override
    public void setColSpan(int columnSpan)
    {
        colSpan = columnSpan;
    }
    @Override
    public int getColSpan()
    {
        return colSpan;
    }
    @Override
    public void setRowSpan(int rowSpan)
    {
        this.rowSpan = rowSpan;
    }
    @Override
    public int getRowSpan()
    {
        return rowSpan;
    }
    @Override
    public void setXPos(int xPosition)
    {
        xPos = xPosition;
    }
    @Override
    public int getXPos()
    {
        return xPos;
    }
    @Override
    public void setYPos(int yPosition)
    {
        yPos = yPosition;
    }
    @Override
    public int getYPos()
    {
        return yPos;
    }
}
