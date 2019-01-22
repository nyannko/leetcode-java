public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(0), r = new ListNode(0);
        ListNode lh = l, rh = r;
        ListNode node = head;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        r.next = null;
        l.next = rh.next;
        return lh.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode l = new ListNode(0);
        ListNode r = new ListNode(0);
        ListNode lh = l, rh = r;
        while (head != null) {
            if (head.val < x) {
                l.next = new ListNode(head.val);
                l = l.next;
            } else {
                r.next = new ListNode(head.val);
                r = r.next;
            }
            head = head.next;
        }
        l.next = rh.next;
        return lh.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1),
                head = a;
        int[] node = {4, 3, 2, 5, 2};
        for (int n : node) {
            a.next = new ListNode(n);
            a = a.next;
        }
        PartitionList p = new PartitionList();
        System.out.println(p.partition(head, 3));
    }
}
