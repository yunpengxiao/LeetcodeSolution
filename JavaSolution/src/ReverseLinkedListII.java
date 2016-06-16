/**
 * Created by xyunpeng on 5/29/16.
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next;
        ListNode p = start.next;
        for (int i = 0; i < n - m; i++) {
            start.next = p.next;
            p.next = pre.next;
            pre.next = p;
            p = start.next;
        }

        return dummy.next;
    }
}


//启发自别人家的算法: https://leetcode.com/discuss/25580/simple-java-solution-with-clear-explanation