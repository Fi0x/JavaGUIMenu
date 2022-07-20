package io.fi0x.javaguimenu;

import io.fi0x.javaguimenu.controller.MainController;
import io.fi0x.javaguimenu.elements.RegularButton;
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
    private MainController controller;
    private String title = "Unnamed";
    private double width = 800;
    private double height = 450;
    private boolean resizable = true;
    private LayoutTypes layout = LayoutTypes.Grid;
    private ArrayList<RegularButton> buttons = new ArrayList<>();

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

        controller = loader.getController();
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
    public void addButton(RegularButton btn)
    {
        buttons.add(btn);
    }

    private Map<String, Object> generateUserOptions()
    {
        Map<String, Object> options = new HashMap<>();

        options.put("layout", layout.toString());
        for(int i = 0; i < buttons.size(); i++)
            options.put("button" + i, buttons.get(i));

        return options;
    }
}
