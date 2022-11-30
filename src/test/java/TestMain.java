import io.fi0x.javaguimenu.GUIWindow;
import io.fi0x.javaguimenu.elements.PriorityButton;
import io.fi0x.javaguimenu.elements.RegularButton;
import io.fi0x.javaguimenu.layouts.LayoutTypes;
import io.fi0x.javalogger.logging.Logger;

public class TestMain
{
    public static void main(String[] args)
    {
        Logger.getInstance().setVerbose(true);
        Logger.getInstance().setDebug(true);

        RegularButton btn1 = new RegularButton();
        btn1.setColIdx(0);
        btn1.setRowIdx(0);
        btn1.setText("Hallo");
        btn1.setColSpan(2);
        GUIWindow.addElement(btn1);

        PriorityButton btn2 = new PriorityButton();
        btn2.setColIdx(0);
        btn2.setRowIdx(1);
        btn2.setText("Priority");
        GUIWindow.addElement(btn2);

        GUIWindow.setColumns(3);
        GUIWindow.setRows(3);
        GUIWindow.setTitle("Test Window");
        GUIWindow.setLayout(LayoutTypes.Grid);

        GUIWindow.start(args);
    }
}
