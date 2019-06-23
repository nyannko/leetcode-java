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
        return prev;
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
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createLinkedList(arr);
        ListNode.printLinkedList(head);
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode.printLinkedList(r.reverseList(head));
    }
}

