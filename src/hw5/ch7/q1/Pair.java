package hw5.ch7.q1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pair<K extends Comparable<K>, V extends Comparable<V>>
        implements Cloneable, Serializable, Comparable<Pair<K,V>> {

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

    public int compareTo(Pair<K, V> other) {
        if (key.compareTo(other.k()) == 0)
            return val.compareTo(other.v());
        return key.compareTo(other.k());
    }

    private void writeObject(ObjectOutputStream os) throws Exception {
        os.defaultWriteObject();
        os.writeObject(key);
        os.writeObject(val);
    }

    private void readObject(ObjectInputStream os) throws Exception {
        os.defaultReadObject();
        key = (K) os.readObject();
        val = (V) os.readObject();
    }

    private K key;
    private V val;
}
