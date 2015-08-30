package hw1.q3;

import java.util.LinkedList;

public class DataAnalyzer {

    public DataAnalyzer(LinkedList<Integer> in) {
        newSequence(in);
    }

    public DataAnalyzer() {
        dataList = new LinkedList<Integer>();
    }

    public void newSequence(LinkedList<Integer> newList) {
        dataList = new LinkedList<Integer>(newList);
    }

    public String getSequence() {
        int length = dataList.size();
        if (length < 1) {return "";}

        String[] sequence_holder = new String[length];
        for(int i=0; i<length; i++){
            sequence_holder[i] = dataList.get(i).toString();
        }
        return String.join(", ", sequence_holder);
    }

    public double average() {
        int length = dataList.size();
        if (length < 1){return 0.0;}
        int sum = 0;
        for (int i: dataList) {
            sum += i;
        }
        return (double)sum / (double)length;
    }

    public int min() {
        LinkedList<Integer> sorted = sortedDataList();
        return sorted.getFirst();
    }

    public int max() {
        LinkedList<Integer> sorted = sortedDataList();
        return sorted.getLast();
    }

    private LinkedList<Integer> sortedDataList() {
        LinkedList<Integer> sorted = new LinkedList<Integer>(dataList);
        sorted.sort(null);
        return sorted;
    }

    private LinkedList<Integer> dataList;
}
