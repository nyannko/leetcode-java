import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedList {
    // naive
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> newList = new ArrayList<>(Arrays.asList(lists));
        while (newList.size() >= 2) {
            ListNode list = merge2List(newList.get(newList.size() - 1), newList.get(newList.size() - 2));
            newList.add(0, list);
            newList.remove(newList.size() - 1);
            newList.remove(newList.size() - 1);
        }
        if (newList.size() == 1) return newList.get(0);
        return null;
    }

    public ListNode merge2List(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode head = p;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
                p = p.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
                p = p.next;
            }
        }

        while (l1 != null) {
            p.next = new ListNode(l1.val);
            l1 = l1.next;
            p = p.next;
        }

        while (l2 != null) {
            p.next = new ListNode(l2.val);
            l2 = l2.next;
            p = p.next;
        }
        return head.next;
    }
}
