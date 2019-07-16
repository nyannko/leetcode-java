package ds.RBTree;

import ds.util.MySet;

public class RBSet<E extends Comparable<E>> implements MySet<E> {

    private RBTree<E, Object> set;

    public RBSet() {
        set = new RBTree<>();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public int size() {
        return set.getSize();
    }

    @Override
    public void add(E e) {
        set.add(e, null);
    }

    @Override
    public void remove(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(E e) {
        return set.contains(e);
    }
}
