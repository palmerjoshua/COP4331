package hw1.q3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class DataAnalyzer {

    /**
     * Constructor that initializes dataList with an existing LinkedList.
     * @param in The LinkedList whose data will populate the DataAnalyzer.
     * @see #newSequence(LinkedList)
     *
     */
    public DataAnalyzer(LinkedList<Integer> in) {
        newSequence(in);
    }

    /**
     * Default constructor that initializes dataList as an empty list.
     * @see #dataList
     */
    public DataAnalyzer() {
        dataList = new LinkedList<Integer>();
    }

    /**
     * Re-initializes dataList with a new LinkedList
     * @param newList The LinkedList whose data will populate the DataAnalyzer.
     * @see #dataList
     */
    public void newSequence(LinkedList<Integer> newList) {
        dataList = new LinkedList<Integer>(newList);
    }

    /**
     * Creates a String containing the sequence of integers stored in dataList
     * @return String of integers separated by commas
     * @see #dataList
     */
    public String getSequence() {
        if(dataList.isEmpty()) {return "";}
        int length = dataList.size();
        String[] sequence_holder = new String[length];
        for(int i=0; i<length; i++){
            sequence_holder[i] = dataList.get(i).toString();
        }
        return String.join(", ", sequence_holder);
    }

    /**
     * Computes the average value in the dataList
     * @return The average value
     * @see #dataList
     */
    public double average() {
        if (dataList.isEmpty()) return 0.0;
        int sum = 0;
        for (int i: dataList) {
            sum += i;
        }
        return (double)sum / (double)dataList.size();
    }

    /**
     * Computes the minimum value in the dataList.
     * @return The smallest value stored in the dataList.
     * @see #max()
     */
    public int min() {
        try {
            return Collections.min(dataList);
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    /**
     * Computes the maximum value in the dataList.
     * @return The largest value stored in the dataList.
     * @see #min()
     */
    public int max() {
        try{
            return Collections.max(dataList);
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    /**
     * The LinkedList that stores the data to be analyzed.
     */
    private LinkedList<Integer> dataList;
}
