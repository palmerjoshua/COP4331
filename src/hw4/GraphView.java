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
    private RectangleIcon bar1, bar2, bar3;
    private JLabel lab1, lab2, lab3;

    public GraphView(GraphModel m) {
        model = m;
        initBars();
        initFields();
        initPanels();
        initFrame();
    }

    public void update(Observable o, Object object) {
        int[] values = model.getBarValues();
        bar1.setWidthPercentage(values[0]);
        bar2.setWidthPercentage(values[1]);
        bar3.setWidthPercentage(values[2]);
        lab1.revalidate(); lab1.repaint();
        lab2.revalidate(); lab2.repaint();
        lab3.revalidate(); lab3.repaint();
    }

    private void initBars() {
        bar1 = new RectangleIcon(Color.GREEN);
        bar2 = new RectangleIcon(Color.BLUE);
        bar3 = new RectangleIcon(Color.CYAN);
        lab1 = new JLabel(bar1);
        lab2 = new JLabel(bar2);
        lab3 = new JLabel(bar3);
    }

    private JTextField newController(final Runnable function) {
        JTextField newField = new JTextField();
        newField.setMaximumSize(new Dimension(Integer.MAX_VALUE, newField.getPreferredSize().height));
        newField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                function.run();
            }
        });
        return newField;
    }

    private void changeModel(int barIndex, String value) {
        try {
            model.setBarValue(barIndex, value);
        } catch (IllegalArgumentException e) {
            System.out.println("ignoring value: '" + value + "'");
        }
    }

    private void initFields() {
        field1 = newController(()->changeModel(0, field1.getText()));
        field2 = newController(()->changeModel(1, field2.getText()));
        field3 = newController(()->changeModel(2, field3.getText()));
    }

    private void initPanels() {
        textPanel = new JPanel(); graphPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        graphPanel.setLayout(new BoxLayout(graphPanel, BoxLayout.PAGE_AXIS));
        textPanel.add(field1);
        textPanel.add(Box.createRigidArea(new Dimension(0, 150)));
        textPanel.add(field2);
        textPanel.add(Box.createRigidArea(new Dimension(0, 150)));
        textPanel.add(field3);
        graphPanel.add(lab1);
        graphPanel.add(lab2);
        graphPanel.add(lab3);
    }

    private void initFrame() {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(720, 480));
        frame.setLayout(new GridLayout(1, 2));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(textPanel);
        frame.add(graphPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GraphModel model = new GraphModel();
        GraphView view = new GraphView(model);
        model.addObserver(view);
    }
}
