package hw1.q3;

import java.util.LinkedList;

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
        int length = dataList.size();
        if (length < 1) {return "";}

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
        int length = dataList.size();
        if (length < 1){return 0.0;}
        int sum = 0;
        for (int i: dataList) {
            sum += i;
        }
        return (double)sum / (double)length;
    }// todo test what happens when dataList is empty for all these functions

    /**
     * Computes the minimum value in the dataList.
     * @return The smallest value stored in the dataList.
     * @see #max()
     * @see #sortedDataList()
     */
    public int min() {
        LinkedList<Integer> sorted = sortedDataList();
        return sorted.getFirst();
    }

    /**
     * Computes the maximum value in the dataList.
     * @return The largest value stored in the dataList.
     * @see #min()
     * @see #sortedDataList()
     */
    public int max() {
        LinkedList<Integer> sorted = sortedDataList();
        return sorted.getLast();
    }

    /**
     * Creates a new list containing the values in dataList sorted in ascending order.
     * @return A new, sorted dataList.
     * @see #min()
     * @see #max()
     */
    private LinkedList<Integer> sortedDataList() {
        LinkedList<Integer> sorted = new LinkedList<Integer>(dataList);
        sorted.sort(null);
        return sorted;
    }

    /**
     * The LinkedList that stores the data to be analyzed.
     */
    private LinkedList<Integer> dataList;
}
