import util.ListNode;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy,
                cur = head,
                next = null;
        while (cur != null) {
            ListNode tmp = cur.next;  // store the following value
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;       // move the pointer
            }
            cur.next = pre.next;      // change the pointer
            pre.next = cur;           // change the pointer
            pre = dummy;              // restore pre
            cur = tmp;                // restore cur
        }
        return dummy.next;
    }
}
