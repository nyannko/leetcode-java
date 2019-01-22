public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return (head.val == val) ? head.next : head;
    }

    public ListNode removeElements2(ListNode head, int val) {
        // remove head
        while (head != null && head.val == val) head = head.next;
        // remove internal nodes
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    public ListNode removeElements3(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (head != null) {
            if (head.val != val) {
                cur.next = head;
                cur = head;
            }
            head = head.next;
        }
        cur.next = null; // in case that all elements in the list are same
        return dummy.next;
    }
}
