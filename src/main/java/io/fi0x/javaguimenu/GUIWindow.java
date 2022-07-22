package io.fi0x.javaguimenu;

import io.fi0x.javaguimenu.controller.MainController;
import io.fi0x.javaguimenu.elements.AbstractElement;
import io.fi0x.javaguimenu.layouts.LayoutTypes;
import io.fi0x.javalogger.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class creates the main window for the menu
 * and contains details of all the contained elements as well as the layout options.
 */
public class GUIWindow extends Application
{
    private static String windowTitle = "Unnamed";
    private static double width = 800;
    private static double height = 450;
    private static String windowIcon = "images/logo.png";
    private static String cssFile = "css/main.css";
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
        primaryStage.getIcons().add(new Image(windowIcon));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(cssFile);
        primaryStage.setScene(scene);
        primaryStage.setResizable(resizable);
        primaryStage.show();
    }

    /**
     * This method will display a new Menu-Window
     * with previously defined settings.
     * @param args Any arguments that should be passed to the javafx application.
     */
    public static void start(String[] args)
    {
        for(String arg : args)
        {
            if(arg.equals("-d"))
                Logger.getInstance().setDebug(true);
            if(arg.equals("-v"))
                Logger.getInstance().setVerbose(true);
        }
        Application.launch(args);
    }

    /**
     * With this method you can set the title of the main window.
     * @param title The title that should be used for the window.
     */
    public static void setTitle(String title)
    {
        windowTitle = title;
    }
    /**
     * This method allows you to adjust the size of the window.
     * @param w The desired window-width.
     * @param h The desired window-height.
     */
    public static void setSize(double w, double h)
    {
        width = w;
        height = h;
    }
    /**
     * Changes the icon of the window.
     * @param icon The path to the image that should be used.
     */
    public static void setWindowIcon(String icon)
    {
        windowIcon = icon;
    }
    /**
     * Replaces the default css-file with a custom one.
     * @param cssFilePath The path to the css-file that should be used.
     */
    public static void setCssFile(String cssFilePath)
    {
        cssFile = cssFilePath;
    }
    /**
     * Sets the resizable-boolean of the javafx-window.
     * @param isResizable Weather or not the menu-window should be resizable.
     *                    Default is true.
     */
    public static void setResizable(boolean isResizable)
    {
        resizable = isResizable;
    }
    /**
     * This method changes the layout inside the menu-window.
     * @param type Which type of layout should be used.
     *             Default is a Grid-layout.
     */
    public static void setLayout(LayoutTypes type)
    {
        layout = type;
    }
    /**
     * You can add menu-elements with this method.
     * All added elements will be displayed in the menu at their specified position.
     * @param node The element to add.
     */
    public static void addElement(AbstractElement node)
    {
        for(int i = 0; i <= elements.size(); i++)
        {
            if(i == elements.size())
            {
                elements.add(node);
                break;
            }
            if(elements.get(i).getRowIdx() > node.getRowIdx())
            {
                elements.add(i, node);
                break;
            }
        }
        Logger.log("Added new element to window", "verbose");
    }
    /**
     * This method changes the behaviour of the element placement inside the layout.
     * @param spaceEvenly If true, element column and row-indices are ignored,
     *                    and they get placed one after another.
     */
    public static void setElementSpacing(boolean spaceEvenly)
    {
        spaceElementsEvenly = spaceEvenly;
    }
    /**
     * This method determines how many columns should be created in a grid.
     * @param columnCount The number of columns to create.
     */
    public static void setColumns(int columnCount)
    {
        columns = columnCount;
    }
    /**
     * This method determines how many rows should be created in a grid.
     * @param rowCount The number of rows to create.
     */
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

        return options;
    }
}
