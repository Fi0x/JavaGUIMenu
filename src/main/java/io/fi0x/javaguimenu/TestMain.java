package io.fi0x.javaguimenu;

import io.fi0x.javaguimenu.elements.RegularButton;
import io.fi0x.javaguimenu.layouts.LayoutTypes;
import io.fi0x.javalogger.logging.Logger;

public class TestMain
{
    public static void main(String[] args)
    {
        Logger.getInstance().setVerbose(true);
        GUIWindow gw = new GUIWindow();

        RegularButton btn1 = new RegularButton();
        btn1.setColIdx(1);
        btn1.setRowIdx(1);
        btn1.setText("Hallo");
        gw.addElement(btn1);
        gw.setColumns(3);
        gw.setRows(3);
        gw.setTitle("Hi");
        gw.setLayout(LayoutTypes.Grid);

        gw.start(args);
    }
}
