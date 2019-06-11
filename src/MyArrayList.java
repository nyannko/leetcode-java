import java.util.Arrays;

public class MyArrayList {
    private int cap;
    private int[] arr;
    private int pointer;

    public MyArrayList(int cap) {
        this.cap = cap;
        pointer = 0;
    }

    public void add(int e) {
        if (pointer >= cap) resize(cap * 2);
        arr[pointer++] = e;
    }

    private void resize(int size) {
        System.out.println("resize");
        int[] newArr = new int[size];
        for (int i = 0; i < pointer; i++) {
            newArr[i] = arr[i];
        }
        cap = size;
        arr = newArr;
    }

    public int pop() {
        assert (pointer >= 0);
        pointer--;
        int res = arr[pointer];
        if (pointer <= cap / 4) resize(cap / 2);

        return res;
    }

    private void getArray() {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(3);
        for (int i = 0; i < 9; i++) {
            list.add(i);
            list.getArray();
        }

        for (int i = 0; i < 9; i++) {
            System.out.println("pointer: " + list.pointer + ", pop :" + list.pop());
            list.getArray();
        }
    }
}
