import java.util.Arrays;

public class MyArrayList<E> {
    private int cap;
    private Object[] arr;
    private int pointer;

    public MyArrayList(int cap) {
        this.cap = cap;
        arr = new Object[cap];
        pointer = 0;
    }

    public void add(E e) {
        if (pointer >= cap) resize(cap * 2);
        arr[pointer++] = e;
    }

    private void resize(int size) {
        System.out.println("resize");
        Object[] newArr = new Object[size];
        for (int i = 0; i < pointer; i++) {
            newArr[i] = arr[i];
        }
        cap = size;
        arr = newArr;
    }

    public E pop() {
        assert (pointer >= 0);
        pointer--;
        E res = (E) arr[pointer];
        if (pointer <= cap / 4) resize(cap / 2);

        return res;
    }

    private void getArray() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(3);
        for (int i = 0; i < 9; i++) {
            System.out.println(i);
            list.add(i);
            list.getArray();
        }

        for (int i = 0; i < 9; i++) {
            System.out.println("pointer: " + list.pointer + ", pop :" + list.pop());
            list.getArray();
        }
    }
}
