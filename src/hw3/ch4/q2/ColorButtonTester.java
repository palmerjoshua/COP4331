package hw3.ch4.q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonTester {

    /**
     * Creates a button with a label and ActionListener given by the user.
     * @param index int corresponding to the desired label
     * @param actionListener The function to run when the button is clicked.
     * @return JButton
     * @throws IllegalArgumentException if the given index is not in {0,1,2}
     */
    private static JButton createButton(int index, ActionListener actionListener) {
        String[] labels = {"Green", "Blue", "Red"};
        try {
            JButton button = new JButton(labels[index]);
            button.addActionListener(actionListener);
            return button;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("index must be in {0,1,2}");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        final ColorCircleIcon icon = new ColorCircleIcon(50, Color.green);
        final JLabel label = new JLabel(icon);
        JButton[] buttons = new JButton[3];

        for(int i=0; i< 3; i++) {
            final int j = i;
            buttons[i] = createButton(i, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    icon.setColor(j);
                    label.repaint();
                }
            });
            frame.add(buttons[i]);
        }
        frame.add(label);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
