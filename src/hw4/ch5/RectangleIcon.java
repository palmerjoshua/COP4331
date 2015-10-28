package hw4.ch5;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RectangleIcon implements Icon {
    public RectangleIcon(Color c) {
        width = 0;
        color = c;
    }
    
    public void setWidthPercentage(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be in [0,100]. Input: " + percentage);
        }
        double p = (double)percentage / 100.0;
        width = (int)Math.floor(360 * p);
    }

    public int getIconHeight() {return HEIGHT;}
    public int getIconWidth() {return width;}

    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, HEIGHT);
        g2.setColor(color);
        g2.fill(rectangle);
        g2.draw(rectangle);
    }
    private int width;
    private final int HEIGHT = 160;
    private Color color;
}
