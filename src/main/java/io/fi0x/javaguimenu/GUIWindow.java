package io.fi0x.javaguimenu;

import io.fi0x.javaguimenu.controller.MainController;
import io.fi0x.javaguimenu.elements.AbstractElement;
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
    private static String windowTitle = "Unnamed";
    private static double width = 800;
    private static double height = 450;
    private static boolean resizable = true;
    private static LayoutTypes layout = LayoutTypes.Grid;
    private static final ArrayList<AbstractElement> elements = new ArrayList<>();
    private static boolean spaceElementsEvenly;
    private static int columns = 1;
    private static int rows = 1;

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

        primaryStage.setTitle(windowTitle);
        primaryStage.setHeight(height);
        primaryStage.setWidth(width);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(resizable);
        primaryStage.show();
    }

    public static void start(String[] args)
    {
        Application.launch(args);
    }

    public static void setTitle(String title)
    {
        windowTitle = title;
    }
    public static void setSize(double w, double h)
    {
        width = w;
        height = h;
    }
    public static void setResizable(boolean isResizable)
    {
        resizable = isResizable;
    }
    public static void setLayout(LayoutTypes type)
    {
        layout = type;
    }
    public static void addElement(AbstractElement node)
    {
        System.out.println("Adding element");
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
        System.out.println("Elements: " + elements.size());
    }
    public static void setElementSpacing(boolean spaceEvenly)
    {
        spaceElementsEvenly = spaceEvenly;
    }
    public static void setColumns(int columnCount)
    {
        columns = columnCount;
    }
    public static void setRows(int rowCount)
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
        options.put("width", width);
        options.put("height", height);

        return options;
    }
}
