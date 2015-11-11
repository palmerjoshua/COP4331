package hw5.ch7.q1;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class PairTest {
    public static void main(String[] args) throws Exception {
        ArrayList<Pair> pairs = deserializePairs();
        showPairData(pairs);
        serializePairs(pairs);
    }

    private static ArrayList<Pair> deserializePairs() throws Exception {
        FileInputStream fis;
        ObjectInputStream ois;
        ArrayList<Pair> pairs;
        try {
            fis = new FileInputStream("object.ser");
            ois = new ObjectInputStream(fis);
            pairs = new ArrayList<>();
            boolean done = false;
            while (!done) {
                try {
                    pairs.add((Pair) ois.readObject());
                } catch (EOFException e) {
                    done = true;
                }
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            pairs = randomPairList();
        }
        return pairs;
    }

    private static void showPairData(ArrayList<Pair> pairs) {
        for (Pair pair : pairs) {
            System.out.println("      Key: " + pair.k());
            System.out.println("    Value: " + pair.v());
            System.out.println("To String: " + pair.toString());
            System.out.println("Hash Code: " + pair.hashCode() + "\n");
        }

        System.out.println("First ==  Third: " + pairs.get(0).equals(pairs.get(2))); // should be true
        System.out.println("First == Second: " + pairs.get(0).equals(pairs.get(1)));// should be false
    }

    private static void serializePairs(ArrayList<Pair> pairs) throws Exception {
        FileOutputStream fos = new FileOutputStream("object.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Pair pair : pairs) {
            oos.writeObject(pair);
        }
        oos.close();
        fos.close();
    }

    private static ArrayList<Pair> randomPairList() {
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(randomIntPair());
        pairs.add(randomIntPair());
        pairs.add(pairs.get(0).clone()); // always have one clone so we can test it
        return pairs;
    }

    private static Pair randomIntPair() {
        Random random = new Random();
        return new Pair<Integer, Integer>(random.nextInt(100), random.nextInt(100));
    }




}
