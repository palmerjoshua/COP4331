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
      path.transform(
            AffineTransform.getTranslateInstance(dx, dy));
   }

   public void draw(Graphics2D g2)
   {
      g2.setPaint(Color.black);//MP Added
      g2.setStroke(new BasicStroke(1));//MP Added
      g2.draw(path);
   }

   public void drawSelection(Graphics2D g2) {
       draw(g2);
       Rectangle2D bounds = path.getBounds();
       double x = bounds.getX(), y = bounds.getY(), width = bounds.getMaxX()-x, height = bounds.getMaxY()-y;
       Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{6}, 0);
       Rectangle2D border = new Rectangle2D.Double(x, y, width, height);
       g2.setPaint(Color.blue);//MP Added
       g2.setStroke(dashed);
       g2.draw(border);
   }

   private GeneralPath path;
}







