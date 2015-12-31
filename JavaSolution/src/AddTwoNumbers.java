/**
 * Created by xyunpeng on 12/30/15.
 */
public class AddTwoNumbers {
    // 这次貌似写得很简洁
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);

        ListNode h = dummy;
        int n = 0;
        while (l1 != null || l2 != null || n == 1) {
            int t = (l1 == null? 0: l1.val) + (l2 == null? 0: l2.val) + n;
            h.next = new ListNode(t % 10);
            n = t / 10;
            h = h.next;
            l1 = (l1 == null? l1: l1.next);
            l2 = (l2 == null? l2: l2.next);
        }
        return dummy.next;
    }
}
