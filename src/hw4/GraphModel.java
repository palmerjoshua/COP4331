package hw4;


import java.util.Observable;

public class GraphModel extends Observable {
    public GraphModel() {
    }

    public GraphModel(int bar1, int bar2, int bar3) {
        barValues[0] = bar1;
        barValues[1] = bar2;
        barValues[2] = bar3;
    }

    public void setBarValue(int barIndex, int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException("Bar value must be in [0,100]. Input: "+ value);
        }
        try {
            barValues[barIndex] = value;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Index must be in [0,2]. Input: " + barIndex);
        }
        setChanged();
        notifyObservers();
    }

    public void setBarValue(int barIndex, String value) {
        try {
            int intVal = Integer.parseInt(value);
            if (intVal < 0 || intVal > 100) {
                throw new IllegalArgumentException("Value must be in [0,100]. Input: " + intVal);
            }
            barValues[barIndex] = intVal;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("barIndex must be in [0,2]. Input: " + barIndex);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Value must be an integer in [0, 100]. Input: "+ value);
        }
        setChanged();
        notifyObservers();
    }
    public int[] getBarValues() {
        return barValues.clone();
    }
    private final int[] barValues = {0,0,0};
}
