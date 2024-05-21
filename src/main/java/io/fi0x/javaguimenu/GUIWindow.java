package io.fi0x.javaguimenu;

import io.fi0x.javaguimenu.controller.MainController;
import io.fi0x.javaguimenu.elements.AbstractElement;
import io.fi0x.javaguimenu.layouts.LayoutTypes;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.IOException;
import java.util.*;

/**
 * This class creates the main window for the menu
 * and contains details of all the contained elements as well as the layout options.
 */
public class GUIWindow extends Application
{
    private static String windowTitle = "Unnamed";
    private static double width = 800;
    private static double height = 450;
    @Setter
    private static String windowIcon = "images/logo.png";
    @Setter
    private static String cssFile = "css/main.css";
    @Setter
    private static boolean resizable = true;
    @Setter
    private static boolean closeAllOnStop = false;
    @Setter
    private static LayoutTypes layout = LayoutTypes.Grid;
    private static final ArrayList<AbstractElement> elements = new ArrayList<>();
    @Setter
    private static boolean spaceElementsEvenly;
    @Setter
    private static int columns = 1;
    @Setter
    private static int rows = 1;
    @Setter
    private static boolean gridLaneVisibility = false;

    /**
     * Default constructor of this class.
     */
    public GUIWindow()
    {
    }

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
    @Override
    public void stop()
    {
        if(closeAllOnStop)
            System.exit(0);
    }

    /**
     * This method will display a new Menu-Window
     * with previously defined settings.
     * @param args Any arguments that should be passed to the javafx application.
     */
    public static void start(String[] args)
    {
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
    }

    private Map<String, Object> generateUserOptions()
    {
        Map<String, Object> options = new HashMap<>();

        options.put("layout", layout);
        options.put("elements", elements);
        options.put("elementSpacing", spaceElementsEvenly);
        options.put("columns", columns);
        options.put("rows", rows);
        options.put("gridLanes", gridLaneVisibility);

        return options;
    }
}
