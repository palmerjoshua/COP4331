package hw4.ch5;
import java.util.Observable;

public class GraphModel extends Observable {
    public void setBarValue(int barIndex, int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Bar value must be in [0,100]. Input: "+ value);
        }
        try {
            barValues[barIndex] = value;
            setChanged();
            notifyObservers();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Index must be in [0,2]. Input: " + barIndex);
        }
    }

    public void setBarValue(int barIndex, String value) {
        try {
            int intVal = (value.equals("")) ? 0 : Integer.parseInt(value);
            if (intVal < 0 || intVal > 100) {
                throw new IllegalArgumentException("Value must be in [0,100]. Input: " + intVal);
            }
            barValues[barIndex] = intVal;
            setChanged();
            notifyObservers();
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("barIndex must be in [0,2]. Input: " + barIndex);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Value must be an integer in [0, 100]. Input: "+ value);
        }
    }
    public int[] getBarValues() {
        return barValues.clone();
    }
    private final int[] barValues = {0,0,0};
}
