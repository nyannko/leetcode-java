import util.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode head = p;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            // connect a list of ListNode
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int value = v1 + v1 + carry;
            head.next = new ListNode(value % 10);
            carry = value / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] val1 = {2, 4, 3};
        int[] val2 = {5, 6, 4};
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode h1 = l1;
        ListNode h2 = l2;
        for (int i = 0; i < val1.length; i++) {
            l1.next = new ListNode(val1[i]);
            l2.next = new ListNode(val2[i]);
            l1 = l1.next;
            l2 = l2.next;
        }
        AddTwoNumbers a = new AddTwoNumbers();
        System.out.println(a.addTwoNumbers(h1.next, h2.next));
    }

}
