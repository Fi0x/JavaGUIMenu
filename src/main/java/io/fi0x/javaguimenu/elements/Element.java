package io.fi0x.javaguimenu.elements;

public interface Element
{
    String getTypeName();

    void setColIdx(int columnIndex);
    int getColIdx();
    void setRowIdx(int rowIndex);
    int getRowIdx();
    void setColSpan(int columnSpan);
    int getColSpan();
    void setRowSpan(int rowSpan);
    int getRowSpan();
    void setXPos(int xPosition);
    int getXPos();
    void setYPos(int yPosition);
    int getYPos();
}
