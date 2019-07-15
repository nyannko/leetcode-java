package ds.AVLTree;

public interface MySet<E> {
    boolean isEmpty();

    int size();

    void add(E e);

    void remove(E e);

    boolean contains(E e);
}
