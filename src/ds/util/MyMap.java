package ds.util;

public interface MyMap<K, V> {
    boolean isEmpty();

    int size();

    void put(K key, V value);

    V get(K key);

    void remove(K key);

    void set(K key, V value);

    boolean contains(K key);
}
