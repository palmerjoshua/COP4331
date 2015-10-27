package hw4;

import java.awt.*;
import java.awt.geom.Rectangle2D;


public class GraphRectangle implements GraphShape {
    private int x, y;
    private int width, height;


    public GraphRectangle(int x, int y, int width, int height) {
        this.x = x; this.y = y;
        this.width = width; this.height = height;
    }

    public void setWidth(int width) {
        if (width < 0 || width > 100)
            throw new IllegalArgumentException("Width must be in [0, 100]");
        this.width = width;
    }

    public void draw(Graphics2D g2) {
        Rectangle2D.Double rectangle = new Rectangle2D.Double(x, y, width, height);
        g2.draw(rectangle);
    }
}
