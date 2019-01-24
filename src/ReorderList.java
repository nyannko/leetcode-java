import util.ListNode;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // split
        ListNode fast = head,
                slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = slow.next;   // l2 = 4 --> null
        slow.next = null;   // head = 1 -- > 2 --> 3 --> null

        // reverse
        ListNode rel2 = null,
                cur = l2;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = rel2;
            rel2 = cur;
            cur = tmp;
        }

        ListNode l1 = head;
        // merge
        while (l1 != null && rel2 != null) {
            ListNode tmp = l1.next;
            l1.next = rel2;
            l1 = l1.next;
            rel2 = tmp;
        }
    }
}
