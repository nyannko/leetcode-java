package ds.rbtree;

import ds.util.MyMap;

public class RBMap<K extends Comparable<K>, V> implements MyMap<K, V> {

    RBTree<K, V> map;

    public RBMap() {
        map = new RBTree<>();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public int size() {
        return map.getSize();
    }

    @Override
    public void put(K key, V value) {
        map.add(key, value);
    }

    @Override
    public V get(K key) {
        return map.get(key);
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(K key, V value) {
        map.set(key, value);
    }

    @Override
    public boolean contains(K key) {
        return map.contains(key);
    }
}
