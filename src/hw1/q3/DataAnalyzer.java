package hw1.q3;

import javax.xml.crypto.Data;
import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Created by josh on 8/27/2015.
 */
public class DataAnalyzer {
    private LinkedList<Integer> dataList;
    private final Pattern input_pattern = Pattern.compile("^[\\d ]+$");

    public DataAnalyzer(String user_string) {
        dataList = new LinkedList<Integer>();
        newSequence(user_string);
    }

    public DataAnalyzer(LinkedList<Integer> in) {
        newSequence(in);
    }

    public DataAnalyzer() {
        dataList = new LinkedList<Integer>();
    }

    public void newSequence(String user_string) throws InvalidParameterException {
        if (!dataList.isEmpty()) {
            dataList.clear();
        }
        if (valid_input(user_string)) {
            String[] split_input = user_string.split(" ");
            for(String s: split_input) {
                dataList.add(Integer.parseInt(s));
            }
        } else {
            throw new InvalidParameterException("Expected a sequence of integers.");
        }
    }

    public void newSequence(LinkedList<Integer> newList) {
        dataList = new LinkedList<Integer>(newList);
    }

    private boolean valid_input(String user_input) {
        Matcher input_matcher = input_pattern.matcher(user_input);
        return input_matcher.matches();
    }

    private int get_length() {
        if (dataList.isEmpty()) {return 0;}
        return dataList.indexOf(dataList.getLast()) + 1;
    }

    public String getSequence() {
        int length = get_length();
        if (length < 1) {return "";}

        String[] sequence_holder = new String[length];
        for(int i=0; i<length; i++){
            sequence_holder[i] = dataList.get(i).toString();
        }
        return String.join(", ", sequence_holder);
    }

    public double average() {
        int length = get_length();
        if (length < 1){return 0.0;}
        int sum = 0;
        for (int i: dataList) {
            sum += i;
        }
        return (double)sum / (double)length;
    }

    private LinkedList<Integer> sortedDataList() {
        LinkedList<Integer> sorted = new LinkedList<Integer>(dataList);
    sorted.sort(null);
    return sorted;
}

    public int min() {
        LinkedList<Integer> sorted = sortedDataList();
        return sorted.getFirst();
    }

    public int max() {
        LinkedList<Integer> sorted = sortedDataList();
        return sorted.getLast();
    }





}
