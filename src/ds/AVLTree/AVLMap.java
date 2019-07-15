package ds.AVLTree;

public class AVLMap<K extends Comparable<K>, V> implements MyMap<K, V> {

    private AVLTree<K, V> avl;

    public AVLMap() {
        avl = new AVLTree<>();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }

    @Override
    public int size() {
        return avl.getSize();
    }

    @Override
    public void put(K key, V value) {
        avl.add(key, value);
    }

    @Override
    public V get(K key) {
        return avl.get(key);
    }

    @Override
    public void remove(K key) {
        avl.remove(key);
    }

    @Override
    public void set(K key, V value) {
        avl.set(key, value);
    }

    @Override
    public boolean contains(K key) {
        return avl.contains(key);
    }
}
