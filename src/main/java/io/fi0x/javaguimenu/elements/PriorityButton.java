package io.fi0x.javaguimenu.elements;

import javafx.scene.Node;
import javafx.scene.control.Button;

/**
 * This class represents a normal javafx button with special settings used for the selected layout.
 */
public class PriorityButton extends RegularButton
{
    @Override
    public Node getNodeVersion()
    {
        Button btn = (Button) super.getNodeVersion();
        btn.setId("priority_button");

        return btn;
    }
}
