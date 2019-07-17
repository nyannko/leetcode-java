package sort;

import java.util.Arrays;

public class MaxHeap {

    private int cap; // initial capacity of the heap
    private int size; // current size of the heap
    private int[] elem; // elements

    public MaxHeap(int cap) {
        this.size = 0;
        this.cap = cap;
        this.elem = new int[cap + 1]; // start from index one
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Heapify
    public MaxHeap(int[] nums, int length) {
        this.size = length;
        this.cap = length;
        this.elem = new int[length + 1];
        for (int i = 0; i < length; i++) {
            elem[i + 1] = nums[i]; // put elements into the heap
        }
        for (int i = length / 2; i >= 1; i--) {
            shiftDown(i);
        }
        System.out.println("Call constructor2, after heapify: " + Arrays.toString(elem));
    }

    public void insert(int val) {
        size++;
        elem[size] = val;
        shiftUp(size);
    }

    public void shiftUp(int index) {
        // while child val is larger than its parent
        while (index > 1 && elem[index] > elem[index / 2]) {
            swap(elem, index, index / 2);
            index /= 2;
        }
    }

    public int remove() {
        // swap the first with the last
        int index = 1;
        int removedElem = elem[index];
        elem[index] = elem[size];
        elem[size] = 0;

        size--;
        shiftDown(index);
        return removedElem;
    }


    public void shiftDown(int index) {
        while (2 * index <= size) { // if current element has the left child
            int max = 2 * index; // switch to the left child
            if (max + 1 <= size && elem[max + 1] > elem[max]) { // if the right child > left child, change index
                max++;
            }
            if (elem[index] >= elem[max]) { // break if curr less than max(left, right)
                break;
            }
            swap(elem, index, max); // swap
            index = max; // again
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // naive
    public void heapSort1(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            insert(nums[i]);
        }
        for (int i = length - 1; i >= 0; i--) {
            res[i] = remove();
        }
        System.out.println("Heap Sort 1: " + Arrays.toString(res));
    }

    // use the heapify constructor
    public void heapSort2() {
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = remove();
        }
        System.out.println("Heap Sort 2: " + Arrays.toString(res));
    }

    // in-place
    public void heapSort3(int[] nums) {
        int length = nums.length;
        // heapify
        for (int i = (length - 1) / 2; i >= 0; i--) {
            inplaceShiftDown(nums, length, i);
        }
        // swap
        for (int i = length - 1; i > 0; i--) {
            swap(nums, 0, i); // swap the largest to the last place
            inplaceShiftDown(nums, i, 0);
        }
        System.out.println("Heap Sort 3: " + Arrays.toString(nums));
    }

    public void inplaceShiftDown(int[] nums, int length, int index) {
        while (2 * index + 1 < length) {
            int max = 2 * index + 1;
            if (max + 1 < length && nums[max] < nums[max + 1]) {
                max++;
            }
            if (nums[index] >= nums[max]) break;
            swap(nums, index, max);
            index = max;
        }
    }

    public static void main(String[] args) {
        int[] nums = {50, 34, 20, 12, 11, 6, 8, 1, 8, 6};
        MaxHeap heap1 = new MaxHeap(100);
        MaxHeap heap2 = new MaxHeap(nums, nums.length);
        MaxHeap heap3 = new MaxHeap(100);
        // getString diff heap sort
        heap1.heapSort1(nums);
        heap2.heapSort2();
        heap3.heapSort3(nums);
    }


}
