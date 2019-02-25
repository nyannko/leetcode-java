import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {

    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<>();

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()) max.offer(min.poll());
    }

    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        else return max.peek();
    }

    public static void main(String[] args) {
        FindMedianfromDataStream f = new FindMedianfromDataStream();
        f.addNum(2);
        f.addNum(3);
        f.addNum(4);
        f.addNum(5);

    }
}
