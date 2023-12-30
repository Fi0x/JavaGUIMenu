package io.fi0x.javaguimenu.elements;

import javafx.scene.Node;

/**
 * This class is used for all elements that should be placed inside the selected layout.
 */
public abstract class AbstractElement
{
    /**
     * The index of the column this element should be in.
     */
    protected int colIdx = -1;
    /**
     * The index of the row this element should be in.
     */
    protected int rowIdx = -1;
    /**
     * The amount of cells in a column this element should occupy.
     */
    protected int colSpan = 1;
    /**
     * The amount of cells in a row this element should occupy.
     */
    protected int rowSpan = 1;
    /**
     * The x-position of this element in an absolute layout.
     */
    protected double xPos;
    /**
     * The y-position of this element in an absolute layout.
     */
    protected double yPos;

    /**
     * Default constructor of this class.
     */
    public AbstractElement()
    {
    }

    /**
     * This method returns the node that this element represents.
     *
     * @return The Node.
     */
    public abstract Node getNodeVersion();

    /**
     * Sets the index for the column that should be used. Index starts at 0.
     * Should only be changed when using grid-layouts.
     *
     * @param columnIndex The index that should be used for this element.
     *                    Must not be greater or equal to the column count.
     */
    public void setColIdx(int columnIndex)
    {
        colIdx = columnIndex;
    }
    /**
     * This method returns the index of the column this element is in.
     *
     * @return The index.
     */
    public int getColIdx()
    {
        return colIdx;
    }
    /**
     * Sets the index for the row that should be used. Index starts at 0.
     * Should only be changed when using grid-layouts.
     *
     * @param rowIndex The index that should be used for this element.
     *                 Must not be greater or equal to the row count.
     */
    public void setRowIdx(int rowIndex)
    {
        rowIdx = rowIndex;
    }
    /**
     * This method returns the index of the row this element is in.
     *
     * @return The index.
     */
    public int getRowIdx()
    {
        return rowIdx;
    }
    /**
     * Determines how many columns this element should occupy. Default is 1.
     *
     * @param columnSpan The amount of columns this element should be in.
     */
    public void setColSpan(int columnSpan)
    {
        colSpan = columnSpan;
    }
    /**
     * This method returns the amount of cells this element spans in its column.
     *
     * @return The column span.
     */
    public int getColSpan()
    {
        return colSpan;
    }
    /**
     * Determines how many rows this element should occupy. Default is 1.
     *
     * @param rowSpan The amount of rows this element should be in.
     */
    public void setRowSpan(int rowSpan)
    {
        this.rowSpan = rowSpan;
    }
    /**
     * This method returns the amount of cells this element spans in its row.
     *
     * @return The row span.
     */
    public int getRowSpan()
    {
        return rowSpan;
    }
    /**
     * Sets the x-offset for this element from its default position.
     *
     * @param xPosition The offset from the default position.
     */
    public void setXPos(double xPosition)
    {
        xPos = xPosition;
    }
    /**
     * This method returns the position of this element in an absolute layout.
     *
     * @return The x-position.
     */
    public double getXPos()
    {
        return xPos;
    }
    /**
     * Sets the y-offset for this element from its default position.
     *
     * @param yPosition The offset from the default position.
     */
    public void setYPos(double yPosition)
    {
        yPos = yPosition;
    }
    /**
     * This method returns the position of this element in an absolute layout.
     *
     * @return The y-position.
     */
    public double getYPos()
    {
        return yPos;
    }
}
