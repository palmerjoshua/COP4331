package hw3.ch4.q2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;


public class ColorCircleIcon implements Icon {
    private int diameter;
    private Color color;

    public ColorCircleIcon(int width, Color color) {
        this.diameter = width;
        this.color = color;
    }

    /**
     * Returns the diameter since height == width for a circle.
     * @return int diameter
     */
    public int getIconWidth() {
        return diameter;
    }

    /**
     * @see #getIconWidth()
     * @return int diameter
     */
    public int getIconHeight() {
        return getIconWidth();
    }

    /**
     * Changes the color of the button based on the user's parameter
     * @param index int corresponding to the desired color
     * @throws IllegalArgumentException if user gives an index not in {0,1,2}
     */
    public void setColor(int index) {
        Color[] colors = {Color.green, Color.blue, Color.red};
        try {
            color = colors[index];
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Index must be in {0,1,2}");
        }
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);

        g2.setColor(color);
        g2.fill(circle);
        g2.draw(circle);
    }
}
