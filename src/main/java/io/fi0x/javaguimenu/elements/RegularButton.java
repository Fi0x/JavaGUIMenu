package io.fi0x.javaguimenu.elements;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class RegularButton extends AbstractElement
{
    private String buttonText;

    public static RegularButton create(int columnIndex, int rowIndex)
    {
        return create(columnIndex, rowIndex, 1, 1);
    }
    public static RegularButton create(double xPosition, double yPosition)
    {
        return create(-1, -1, xPosition, yPosition);
    }
    public static RegularButton create(int columnIndex, int rowIndex, double xPosition, double yPosition)
    {
        return create(columnIndex, rowIndex, 1, 1, xPosition, yPosition);
    }
    public static RegularButton create(int columnIndex, int rowIndex, int columnSpan, int rowSpan)
    {
        return create(columnIndex, rowIndex, columnSpan, rowSpan, 0, 0);
    }
    public static RegularButton create(int columnIndex, int rowIndex, int columnSpan, int rowSpan, double xPosition, double yPosition)
    {
        RegularButton btn = new RegularButton();
        btn.setColIdx(columnIndex);
        btn.setRowIdx(rowIndex);
        btn.setColSpan(columnSpan);
        btn.setRowSpan(rowSpan);
        btn.setXPos(xPosition);
        btn.setYPos(yPosition);
        return btn;
    }

    @Override
    public Node getNodeVersion()
    {
        Button btn = new Button();

        btn.setText(buttonText);

        return btn;
    }

    public void setText(String text)
    {
        buttonText = text;
    }
}
