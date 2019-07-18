package ds.btree;

import java.lang.reflect.Array;

public class KVTest<E> {
    private E[] arr;

    public E[] createArr(Class<E> type, int len) {
        arr = (E[]) Array.newInstance(type, len);
        return arr;
    }

    public E[] getArray() {
        return arr;
    }

    public static void main(String[] args) {
        KVTest<String> foo = new KVTest<>();
        String[] arr = foo.createArr(String.class, 2);
    }
}


