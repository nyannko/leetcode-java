import java.util.Arrays;

public class MaxHeapV2 {

    private int size;
    private int cap;
    private int[] elem;

    public MaxHeapV2(int cap) {
        this.elem = new int[cap + 1]; // root start from the index 1
        this.cap = cap; // the total capacity of the heap
        this.size = 0; // current element numbers in the heap
    }

    // heapify
    public MaxHeapV2(int[] arr, int n) {
        this.cap = n;
        this.size = n;
        this.elem = new int[n + 1];
        for (int i = 0; i < n; i++) {
            elem[i + 1] = arr[i];
        }
        // find the last parent node
        for (int i = size / 2; i >= 1; i--) {
            shiftDown(i);
        }
        System.out.println(Arrays.toString(elem));
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void getHeap() {
        System.out.println(Arrays.toString(this.elem));
    }

    public void insert(int node) {
        assert (this.size + 1 <= cap);
        // insert a new node
        this.size++;
        elem[this.size] = node;
        // shift up
        shiftUp(this.size);
    }

    public int getLeft(int index) {
        return elem[index * 2];
    }

    public int getRight(int index) {
        return elem[index * 2 + 1];
    }

    public int remove() {
        int index = 1;
        int removedElem = elem[index];
        elem[index] = elem[size];
        size--;
        shiftDown(index);
        return removedElem;
    }

    public void shiftDown(int index) {
        while (2 * index <= size) { // if the left child exists
            int max = 2 * index; // switch to a new base
            while (max + 1 <= size && elem[max] < elem[max + 1]) { // if right child > left child
                max += 1; // find the index of the max value
            }
            if (elem[index] >= elem[max]) {
                break; // break if the root value > max value
            }
            swap(index, max);
            index = max;
        }
    }


    public void shiftDown1(int index) {
        while (index < this.size && getLeft(index) != 0) { // if this root has a left child
            System.out.println(index);
            if (getLeft(index) > elem[index]) {
                if (getLeft(index) > getRight(index)) { // if left > right
                    swap(index, index * 2);
                    index = index * 2;
                } else {
                    swap(index, index * 2 + 1);
                    index = index * 2 + 1;
                }
            } else break;
        }
    }

    private void swap(int a, int b) {
        int tmp = elem[a];
        elem[a] = elem[b];
        elem[b] = tmp;
    }

    private void shiftUp(int index) {
        while (index > 1 && elem[index] > elem[index / 2]) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    public void heapSort1(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            insert(nums[i]);
        } // nlog(n)
        System.out.println("heap sort1" + Arrays.toString(elem));
        for (int i = length - 1; i >= 0; i--) {
            res[i] = remove();
        } //nlog(n)
        System.out.println("heap sort1" + Arrays.toString(elem));
        System.out.println("heap sort1" + Arrays.toString(res));
    }

    public void heapSort2() {
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = remove();
        }
        System.out.println(Arrays.toString(res));
    }

    // n = nums.length, shift down the element in kth index
    public void inplaceShiftDown(int[] nums, int n, int index) {
        while (2 * index + 1 < n) {
            int max = 2 * index + 1;
            while (max + 1 < n && nums[max + 1] > nums[max]) {
                max++;
            }
            if (nums[index] >= nums[max]) {
                break;
            }
            swap(nums, index, max);
            index = max;
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    // In-place heap sort
    public void heapSort3(int[] nums) {
        int length = nums.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            inplaceShiftDown(nums, length, i);
        }
        for (int i = length - 1; i > 0; i--) {
            swap(nums, 0, i);
            inplaceShiftDown(nums, i, 0);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {50, 34, 20, 12, 11, 6, 8, 1, 8, 6};
        MaxHeapV2 heap = new MaxHeapV2(100);
        MaxHeapV2 heap2 = new MaxHeapV2(nums, nums.length);
        MaxHeapV2 heap3 = new MaxHeapV2(100);
        // test heap sort 1
        heap.heapSort1(nums);
        heap2.heapSort2();
        heap3.heapSort3(nums);
        // test heap
//        System.out.println(heap.size);
//        for (int i : nums) {
//            heap.insert(i);
//        }
//        System.out.println(heap.size == nums.length);
//        heap.getHeap();
//        System.out.println(heap.remove());
//        heap.getHeap();
    }
}
