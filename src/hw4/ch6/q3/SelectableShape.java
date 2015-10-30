package hw4.ch6.q3;

import java.awt.*;

/**
 A shape that manages its selection state.
 */
public abstract class SelectableShape implements SceneShape
{
    public void setSelected(boolean b)
    {
        selected = b;
    }

    public boolean isSelected()
    {
        return selected;
    }

    public abstract void drawSelection(Graphics2D g2);


    private boolean selected;
}
