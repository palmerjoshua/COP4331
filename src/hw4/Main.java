package hw4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    private static JTextField getTextField(KeyListener keyListener) {
        JTextField field = new JTextField();
        field.addKeyListener(keyListener);
        return field;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(1, 2));
        JPanel textPanel = new JPanel(),
               graphPanel = new JPanel();


        GraphRectangle rec = new GraphRectangle(50, 50, 50, 20);

        JTextField field = new JTextField();
        KeyListener listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                System.out.println(field.getText());
            }
        };
        field.addKeyListener(listener);

        textPanel.add(field);
        textPanel.setLayout(new GridBagLayout());


        frame.add(textPanel);
        frame.add(graphPanel);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(720, 480);
        frame.setVisible(true);
    }
}
