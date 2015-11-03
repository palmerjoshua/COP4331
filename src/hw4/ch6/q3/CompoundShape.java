package hw4.ch6.q3;

import java.awt.*;
import java.awt.geom.*;

/**
A scene shape that is composed of multiple geometric shapes.
*/
public abstract class CompoundShape extends SelectableShape
{
    public CompoundShape()
    {
      path = new GeneralPath();
    }

    protected void add(Shape s)
    {
      path.append(s, false);
    }

    public boolean contains(Point2D aPoint)
    {
      return path.contains(aPoint);
    }

    public void translate(int dx, int dy)
    {
      path.transform(AffineTransform.getTranslateInstance(dx, dy));
    }

    public void draw(Graphics2D g2)
    {
      g2.draw(path);
    }

    /**
     * Draws a blue dashed border around a selected shape,
     * and draws blue squares in the corners of the border.
     * @param g2 The Graphics object used to draw the shapes.
     * @see #drawSelectedBorder(Graphics2D)
     * @see #drawSelectedCorners(Graphics2D)
     */
    public void drawSelection(Graphics2D g2) {
        drawSelectedBorder(g2);
        drawSelectedCorners(g2);
    }

    /**
     * Draws a blue dashed border around the shape.
     * @param g2 the Graphics object used to draw the shapes.
     */
    private void drawSelectedBorder(Graphics2D g2) {
        Rectangle2D bounds = path.getBounds();
        double x = bounds.getX(), y = bounds.getY(), width = bounds.getMaxX()-x, height = bounds.getMaxY()-y;
        Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{6}, 0);
        Rectangle2D border = new Rectangle2D.Double(x, y, width, height);

        g2.setStroke(dashed);
        g2.setColor(Color.BLUE);
        g2.draw(border);
        g2.setStroke(new BasicStroke()); // reset so other shapes aren't affected
        g2.setColor(Color.BLACK);
    }

    /**
     * Draws blue squares in the corners of the shape's
     * border drawn by drawSelectedBorder()
     * @param g2 the Graphics object used to draw the shapes.
     * @see #drawSelectedBorder(Graphics2D)
     */
    private void drawSelectedCorners(Graphics2D g2) {
        Rectangle2D bounds = path.getBounds();
        double x = bounds.getX(), y = bounds.getY(), width = bounds.getMaxX()-x, height = bounds.getMaxY()-y;
        Rectangle2D.Double[] corners = {
                new Rectangle2D.Double(x, y, 6, 6),
                new Rectangle2D.Double((x+width)-6, y, 6, 6),
                new Rectangle2D.Double(x, (y+height)-6, 6, 6),
                new Rectangle2D.Double((x+width)-6, (y+height)-6, 6, 6)
        };
        g2.setPaint(Color.BLUE);
        for (Rectangle2D.Double corner : corners) {
            g2.fill(corner);
        }
        g2.setPaint(Color.BLACK); // reset so other shapes aren't affected
    }

    private GeneralPath path;
}







