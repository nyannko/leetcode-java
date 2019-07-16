package ds.BTree;

import java.lang.reflect.Array;

public class TestKV<E> {
    private E[] arr;

    public E[] createArr(Class<E> type, int len) {
        arr = (E[]) Array.newInstance(type, len);
        return arr;
    }

    public E[] getArray() {
        return arr;
    }

    public static void main(String[] args) {
        TestKV<String> foo = new TestKV<>();
        String[] arr = foo.createArr(String.class, 2);
    }
}


