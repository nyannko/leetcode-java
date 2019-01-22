public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode nodeA = headA,
                nodeB = headB;
        while (headA != headB) {
            headA = (headA == null) ? nodeB : headA.next;
            headB = (headB == null) ? nodeA : headB.next;
        }
        return headA;
    }
}
