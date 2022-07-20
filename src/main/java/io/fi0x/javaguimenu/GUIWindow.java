package io.fi0x.javaguimenu;

import io.fi0x.javaguimenu.controller.MainController;
import io.fi0x.javaguimenu.elements.Element;
import io.fi0x.javaguimenu.layouts.LayoutTypes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GUIWindow extends Application
{
    private String title = "Unnamed";
    private double width = 800;
    private double height = 450;
    private boolean resizable = true;
    private LayoutTypes layout = LayoutTypes.Grid;
    private final ArrayList<Element> elements = new ArrayList<>();
    private boolean spaceElementsEvenly;
    private int columns = 1;
    private int rows = 1;

    @Override
    public void start(Stage primaryStage)
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root;
        try
        {
            root = loader.load();
        } catch(IOException e)
        {
            System.exit(999);
            return;
        }

        MainController controller = loader.getController();
        controller.setUserOptions(generateUserOptions());

        primaryStage.setTitle(title);
        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(resizable);
        primaryStage.show();
    }

    public void start(String[] args)
    {
        Application.launch(args);
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setSize(double w, double h)
    {
        width = w;
        height = h;
    }
    public void setResizable(boolean isResizable)
    {
        resizable = isResizable;
    }
    public void setLayout(LayoutTypes type)
    {
        layout = type;
    }
    public void addElement(Element node)
    {
        for(int i = 0; i <= elements.size(); i++)
        {
            if(i == elements.size())
            {
                elements.add(node);
                break;
            }
            if(elements.get(i).getRowIdx() >= node.getRowIdx())
            {
                elements.add(i, node);
                break;
            }
        }
    }
    public void setElementSpacing(boolean spaceEvenly)
    {
        spaceElementsEvenly = spaceEvenly;
    }
    public void setColumns(int columnCount)
    {
        columns = columnCount;
    }
    public void setRows(int rowCount)
    {
        rows = rowCount;
    }

    private Map<String, Object> generateUserOptions()
    {
        Map<String, Object> options = new HashMap<>();

        options.put("layout", layout);
        options.put("elements", elements);
        options.put("elementSpacing", spaceElementsEvenly);
        options.put("columns", columns);
        options.put("rows", rows);

        return options;
    }
}
