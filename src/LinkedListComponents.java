import util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {
    class Solution {
        public int numComponents(ListNode head, int[] G) {
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < G.length; i++) {
                set.add(G[i]);
            }
            int res = 0;
            while (head != null) {
                if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                    res++;
                }
                head = head.next;
            }
            return res;
        }
    }
}
