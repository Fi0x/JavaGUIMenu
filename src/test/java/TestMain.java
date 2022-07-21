import io.fi0x.javaguimenu.GUIWindow;
import io.fi0x.javaguimenu.elements.RegularButton;
import io.fi0x.javaguimenu.layouts.LayoutTypes;
import io.fi0x.javalogger.logging.Logger;

public class TestMain
{
    public static void main(String[] args)
    {
        Logger.getInstance().setVerbose(true);

        RegularButton btn1 = new RegularButton();
        btn1.setColIdx(0);
        btn1.setRowIdx(0);
        btn1.setText("Hallo");
        GUIWindow.addElement(btn1);
        GUIWindow.setColumns(3);
        GUIWindow.setRows(3);
        GUIWindow.setTitle("Hi");
        GUIWindow.setLayout(LayoutTypes.VBox);

        GUIWindow.start(args);
    }
}
