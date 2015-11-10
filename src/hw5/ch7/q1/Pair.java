package hw5.ch7.q1;

import java.util.ArrayList;

public class Pair<K, V> implements Cloneable {

    public static void main(String[] args) {
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
        pairs.add(new Pair<>(5, 6));
        pairs.add(new Pair<>(8, 9));
        pairs.add(pairs.get(0).clone());

        for (Pair<Integer, Integer> pair : pairs) {
            System.out.println("Key: "+ pair.k() + " Value: " + pair.v());
            System.out.println("To String: " + pair.toString());
            System.out.println("Hash Code: " + pair.hashCode() + "\n");
        }

        System.out.println("First ==  Third: " + pairs.get(0).equals(pairs.get(2)));
        System.out.println("First == Second: " + pairs.get(0).equals(pairs.get(1)));
    }

    public Pair(K k, V v) {
        key = k;
        val = v;
    }
    public K k() {return key;}
    public V v() {return val;}

    public boolean equals(Object o) {
        if (o == null) return false;
        if (!getClass().equals(o.getClass())) return false;
        final Pair<K,V> other = (Pair<K,V>) o;
        return key.equals(other.k()) && val.equals(other.v());
    }

    public int hashCode() {
        return key.hashCode() + val.hashCode();
    }

    public String toString() {
        return this.getClass().getName()+"["+key.toString()+", "+val.toString()+"]";
    }

    public Pair<K,V> clone() {
        return new Pair<>(k(), v());
    }

    private K key;
    private V val;
}
