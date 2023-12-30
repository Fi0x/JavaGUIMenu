package io.fi0x.javaguimenu.elements;

/**
 * This interface allows a class to listen for trigger events.
 */
public interface Listener
{
    /**
     * This method gets triggered, when the sender-element is triggered.
     *
     * @param sender The element that got triggered.
     */
    void trigger(AbstractElement sender);
}
