package io.fi0x.javaguimenu;

import io.fi0x.javalogger.logging.Logger;

public class TestMain
{
    public static void main(String[] args)
    {
        Logger.getInstance().setVerbose(true);
        new GUIWindow().start(args);
    }
}
