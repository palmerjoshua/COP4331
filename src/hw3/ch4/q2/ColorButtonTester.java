package hw3.ch4.q2;
import javax.swing.*;
import java.awt.*;

public class ColorButtonTester {

    private static JButton createButton(int index) {
        String[] labels = {"Green", "Blue", "Red"};
        try {
            return new JButton(labels[index]);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("index must be in {0,1,2}");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton[] buttons = new JButton[3];
        for(int i=0; i< 3; i++) {
            buttons[i] = createButton(i);
        }

        frame.setLayout(new FlowLayout());
        for(JButton b : buttons) {
            frame.add(b);
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }
}
