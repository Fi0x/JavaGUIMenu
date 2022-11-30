package io.fi0x.javaguimenu.elements;

import io.fi0x.javalogger.logging.Logger;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

/**
 * This class represents a normal javafx button with special settings used for the selected layout.
 */
public class RegularButton extends AbstractElement
{
    protected String buttonText;
    protected final ArrayList<Listener> listeners = new ArrayList<>();

    /**
     * Get an object of this UI element to place later.
     * @param columnIndex The index of the column this button should be in.
     * @param rowIndex The index of the row this button should be in.
     * @return The new object with the desired settings.
     */
    public static RegularButton create(int columnIndex, int rowIndex)
    {
        return create(columnIndex, rowIndex, 1, 1);
    }
    /**
     * Get an object of this UI element to place later.
     * @param xPosition The x-offset of this element from its default position.
     * @param yPosition The y-offset of this element from its default position.
     * @return The new object with the desired settings.
     */
    public static RegularButton create(double xPosition, double yPosition)
    {
        return create(-1, -1, xPosition, yPosition);
    }
    /**
     * Get an object of this UI element to place later.
     * @param columnIndex The index of the column this button should be in.
     * @param rowIndex The index of the row this button should be in.
     * @param xPosition The x-offset of this element from its default position.
     * @param yPosition The y-offset of this element from its default position.
     * @return The new object with the desired settings.
     */
    public static RegularButton create(int columnIndex, int rowIndex, double xPosition, double yPosition)
    {
        return create(columnIndex, rowIndex, 1, 1, xPosition, yPosition);
    }
    /**
     * Get an object of this UI element to place later.
     * @param columnIndex The index of the column this button should be in.
     * @param rowIndex The index of the row this button should be in.
     * @param columnSpan How many columns this element should fill.
     * @param rowSpan How many rows this element should fill.
     * @return The new object with the desired settings.
     */
    public static RegularButton create(int columnIndex, int rowIndex, int columnSpan, int rowSpan)
    {
        return create(columnIndex, rowIndex, columnSpan, rowSpan, 0, 0);
    }
    /**
     * Get an object of this UI element to place later.
     * @param columnIndex The index of the column this button should be in.
     * @param rowIndex The index of the row this button should be in.
     * @param columnSpan How many columns this element should fill.
     * @param rowSpan How many rows this element should fill.
     * @param xPosition The x-offset of this element from its default position.
     * @param yPosition The y-offset of this element from its default position.
     * @return The new object with the desired settings.
     */
    public static RegularButton create(int columnIndex, int rowIndex, int columnSpan, int rowSpan, double xPosition, double yPosition)
    {
        RegularButton btn = new RegularButton();
        btn.setColIdx(columnIndex);
        btn.setRowIdx(rowIndex);
        btn.setColSpan(columnSpan);
        btn.setRowSpan(rowSpan);
        btn.setXPos(xPosition);
        btn.setYPos(yPosition);

        Logger.log("New button created", Logger.TEMPLATE.VERBOSE);

        return btn;
    }

    /**
     * This method adds a listener to the button.
     * @param listener The listener that should be added.
     */
    public void addListener(Listener listener)
    {
        listeners.add(listener);
    }

    @Override
    public Node getNodeVersion()
    {
        Button btn = new Button();

        btn.setText(buttonText);
        btn.setId("regular_button");
        btn.setOnMouseClicked(event ->
        {
            final RegularButton sender = this;
            for(Listener listener : listeners)
                new Thread(() -> listener.trigger(sender)).start();
        });

        return btn;
    }

    /**
     * Set the text this button should display.
     * @param text The text to display.
     */
    public void setText(String text)
    {
        buttonText = text;
    }
}
