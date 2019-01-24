import util.ListNode;

import java.util.*;

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
        p.next = (l1 != null) ? l1 : l2;
        return head.next;
    }

    // heap
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (l1, l2) -> {
            if (l1.val < l2.val) {
                return -1;
            } else if (l1.val == l2.val) {
                return 0;
            } else {
                return 1;
            }
        });

        ListNode dummy = new ListNode(0), head = dummy;
        for (ListNode list : lists) {
            if (list != null) {
                q.add(list);
            }
        }

        while (!q.isEmpty()) {
            head.next = q.poll();
            head = head.next;

            if (head.next != null) {
                q.add(head.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int l, int r) {
        if (l == r) return lists[l];
        else if (l < r) {
            int m = (l + r) >>> 1;
            ListNode l1 = partition(lists, l, m);
            ListNode l2 = partition(lists, m + 1, r);
            return merge2List(l1, l2);
        }
        return null;
    }


    public static void main(String[] args) {
        MergeKSortedList m = new MergeKSortedList();
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        ListNode b = new ListNode(2);
        b.next = new ListNode(3);
        ListNode c = new ListNode(5);
        c.next = new ListNode(7);
        ListNode[] l = {a, b, c};
        m.mergeKLists3(l);
    }
}
