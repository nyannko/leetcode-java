import util.ListNode;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head,
                slow = head,
                pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l = sortList(head), r = sortList(slow);
        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                head.next = l;
                l = l.next;
            } else {
                head.next = r;
                r = r.next;
            }
            head = head.next;
        }
        head.next = (l != null) ? l : r;
        return dummy.next;
    }
}
