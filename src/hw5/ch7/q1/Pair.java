package hw5.ch7.q1;

public class Pair<K, V> {
    public Pair(K k, V v) {
        key = k;
        val = v;
    }
    public K k() {return key;}
    public V v() {return val;}

    public boolean equals(Object o) {
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        final Pair<K,V> other = (Pair<K,V>) o;
        return key.equals(other.k()) && val.equals(other.v());
    }

    public int hashCode() {
        return key.hashCode() + val.hashCode();
    }

    public String toString() {
        return this.getClass().getName()+"["+key.toString()+", "+val.toString()+"]";
    }


    // todo implement clone()

    private K key;
    private V val;
}
