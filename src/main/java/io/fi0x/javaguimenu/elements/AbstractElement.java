package io.fi0x.javaguimenu.elements;

import javafx.scene.Node;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is used for all elements that should be placed inside the selected layout.
 */
@Setter
@Getter
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
}
