package io.fi0x.javaguimenu.layouts;

import io.fi0x.javaguimenu.elements.Element;
import io.fi0x.javalogger.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Map;

public class AbsoluteLayout extends Pane
{
    private final Map<String, Object> settings;
    private ArrayList<Element> elements;

    public AbsoluteLayout(Map<String, Object> userSettings)
    {
        settings = userSettings;
    }

    @FXML
    private void initialize()
    {
        setUserOptions(settings);
    }

    private void setUserOptions(Map<String, Object> settings)
    {
        for(Map.Entry<String, Object> entry : settings.entrySet())
        {
            if("elements".equals(entry.getKey()))
                elements = (ArrayList<Element>) entry.getValue();
            else
                Logger.log("Invalid user-settings-entry in grid layout detected", "info");
        }
        addAllElements();
    }

    private void addAllElements()
    {
        for(Element e : elements)
        {
            Node n = (Node) e;
            n.setTranslateX(e.getXPos());
            n.setTranslateY(e.getYPos());
            this.getChildren().add(n);
        }
    }
}
