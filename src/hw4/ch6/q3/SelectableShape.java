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

    public void drawSelection(Graphics2D g2)
    {
    // this is where the magic happens
        translate(1, 1);
        draw(g2);
        translate(1, 1);
        draw(g2);
        translate(-2, -2);
    }

    private boolean selected;
}
