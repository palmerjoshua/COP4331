package hw4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class GraphView implements Observer {
    private GraphModel model;
    private JTextField field1, field2, field3;
    private JPanel textPanel, graphPanel;
    private JFrame frame;
    private RectangleIcon bar1, bar2, bar3;
    private JLabel lab1, lab2, lab3;

    private void initBars() {
        bar1 = new RectangleIcon(Color.GREEN);
        bar2 = new RectangleIcon(Color.BLUE);
        bar3 = new RectangleIcon(Color.CYAN);
        lab1 = new JLabel(bar1);
        lab2 = new JLabel(bar2);
        lab3 = new JLabel(bar3);
    }

    private void initFields() {
        field1 = new JTextField(); field2 = new JTextField(); field3 = new JTextField();
        field1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    model.setBarValue(0, field1.getText());
                } catch (IllegalArgumentException ex) {
                    System.out.println("Ignoring input: '"+field1.getText()+"'");
                }
            }
        });
        field2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    model.setBarValue(1, field2.getText());
                } catch (IllegalArgumentException ex) {System.out.println("Ignoring input: '"+field2.getText()+"'");}
            }
        });
        field3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    model.setBarValue(2, field3.getText());
                } catch (IllegalArgumentException ex) {System.out.println("Ignoring input: '"+field3.getText()+"'");}
            }
        });
    }

    private void initPanels() {
        textPanel = new JPanel(); graphPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        textPanel.setPreferredSize(new Dimension(300, 480));
        graphPanel.setLayout(new BoxLayout(graphPanel, BoxLayout.PAGE_AXIS));
        graphPanel.setPreferredSize(new Dimension(420, 480));
        textPanel.add(field1);
        textPanel.add(field2);
        textPanel.add(field3);
        graphPanel.add(lab1);
        graphPanel.add(lab2);
        graphPanel.add(lab3);
    }

    public void initFrame() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(720, 480));
        frame.setLayout(new GridLayout(1, 2));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(textPanel);
        frame.add(graphPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public GraphView() {
        model = new GraphModel();
        initBars();
        initFields();
        initPanels();
        initFrame();
    }

    public void update(Observable o, Object object) {
        final RectangleIcon[] icons = {bar1, bar2, bar3};
        final JLabel[] labels = {lab1, lab2, lab3};
        int[] vals = model.getBarValues();
        for (int i=0; i < 3; i++) {
            icons[i].setWidth(vals[i]);
            labels[i].repaint();
        }

    }

    public static void main(String[] args) {
        GraphView view = new GraphView();

    }
}
