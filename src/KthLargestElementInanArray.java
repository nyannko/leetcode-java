import java.util.PriorityQueue;

public class KthLargestElementInanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k + 1);
        for (int num : nums) {
            q.offer(num);
            System.out.println("Befor pop: " + q);
            if (q.size() > k) {
                q.poll();
            }
            System.out.println("After pop: " + q);
        }
        return q.poll();
    }

    public static void main(String[] args) {
        KthLargestElementInanArray k = new KthLargestElementInanArray();
        k.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 3);
    }
}
