package Microsoft;

/**
 * Created by xyunpeng on 2/20/16.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;

        while (cur != null && cur.next != null) {
            ListNode t = cur.next;
            pre.next = t;
            cur.next = t.next;
            t.next = cur;
            pre = cur;
            cur = pre.next;
        }

        return dummy.next;
    }
}
