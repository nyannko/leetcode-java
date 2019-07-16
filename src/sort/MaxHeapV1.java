package sort;

import java.util.Arrays;

public class MaxHeapV1<Item extends Comparable> {
    protected int cap;
    protected int count;
    protected Item[] heap;

    // start from index one
    public MaxHeapV1(int cap) {
        this.heap = (Item[])new Comparable[cap];
        this.cap = cap;
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void insert(Item item) {
        assert(this.count + 1 <= cap);
        heap[count + 1] = item;
        this.count++;
        shiftUp(this.count);
    }

    private void shiftUp(int index) {
        // parent node less than child node
        while (index > 1 && heap[index/2].compareTo(heap[index]) < 0) {
           swap(index/2, index);
           index /= 2;
        }
    }

    private void swap(int p1, int p2) {
        Item temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    public static void main(String[] args) {
        MaxHeapV1 mh = new MaxHeapV1(100);
        System.out.println(mh.size());
        System.out.println(mh.isEmpty());

        MaxHeapV1<Integer> maxHeap = new MaxHeapV1<Integer>(100);
        int N = 50; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.insert((int) (Math.random() * M));
        System.out.println(maxHeap.size());
        System.out.println(Arrays.toString(maxHeap.heap));
    }
}
