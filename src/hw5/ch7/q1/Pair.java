package hw5.ch7.q1;

public class Pair<K, V> {
    public Pair(K k, V v) {
        key = k;
        val = v;
    }
    public K k() {return key;}
    public V v() {return val;}

    public boolean equals(Object o) { // todo implement
        return false;
    }

    public int hashCode() {
        return key.hashCode() + val.hashCode();
    }

    public String toString() {
        return key+", "+val;
    }

    // todo implement clone()

    private K key;
    private V val;
}
