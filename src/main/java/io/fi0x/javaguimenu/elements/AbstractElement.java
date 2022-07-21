package io.fi0x.javaguimenu.elements;

import javafx.scene.Node;

/**
 * This class is used for all elements that should be placed inside the selected layout.
 */
public abstract class AbstractElement
{
    protected int colIdx = -1;
    protected int rowIdx = -1;
    protected int colSpan = 1;
    protected int rowSpan = 1;
    protected double xPos;
    protected double yPos;

    public abstract Node getNodeVersion();

    /**
     * Sets the index for the column that should be used. Index starts at 0.
     * Should only be changed when using grid-layouts.
     * @param columnIndex The index that should be used for this element.
     *                    Must not be greater or equal to the column count.
     */
    public void setColIdx(int columnIndex)
    {
        colIdx = columnIndex;
    }
    public int getColIdx()
    {
        return colIdx;
    }
    /**
     * Sets the index for the row that should be used. Index starts at 0.
     * Should only be changed when using grid-layouts.
     * @param rowIndex The index that should be used for this element.
     *                 Must not be greater or equal to the row count.
     */
    public void setRowIdx(int rowIndex)
    {
        rowIdx = rowIndex;
    }
    public int getRowIdx()
    {
        return rowIdx;
    }
    /**
     * Determines how many columns this element should occupy. Default is 1.
     * @param columnSpan The amount of columns this element should be in.
     */
    public void setColSpan(int columnSpan)
    {
        colSpan = columnSpan;
    }
    public int getColSpan()
    {
        return colSpan;
    }
    /**
     * Determines how many rows this element should occupy. Default is 1.
     * @param rowSpan The amount of rows this element should be in.
     */
    public void setRowSpan(int rowSpan)
    {
        this.rowSpan = rowSpan;
    }
    public int getRowSpan()
    {
        return rowSpan;
    }
    /**
     * Sets the x-offset for this element from its default position.
     * @param xPosition The offset from the default position.
     */
    public void setXPos(double xPosition)
    {
        xPos = xPosition;
    }
    public double getXPos()
    {
        return xPos;
    }
    /**
     * Sets the y-offset for this element from its default position.
     * @param yPosition The offset from the default position.
     */
    public void setYPos(double yPosition)
    {
        yPos = yPosition;
    }
    public double getYPos()
    {
        return yPos;
    }
}
