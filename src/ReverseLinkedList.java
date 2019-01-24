import util.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev.next;
    }

    public ListNode reverseListRecursion(ListNode head) {
        ListNode prev = dfs(null, head);
        return prev;
    }

    public ListNode dfs(ListNode prev, ListNode head) {
        if (head == null) {
            return prev;
        }
        ListNode tmp = head.next;
        head.next = prev;
        return dfs(head, tmp);
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i = 1; i < 6; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ReverseLinkedList r = new ReverseLinkedList();
//        r.reverseList(head);
        r.reverseListRecursion(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
