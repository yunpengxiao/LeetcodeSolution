package FaceBook;

/**
 * Created by xyunpeng on 1/5/16.
 */
public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            ListNode next = cur.next;
            if (count == k) {
                count = 0;
                pre = reverseKElements(pre, next);
            }
            cur = next;
        }

        return dummy.next;
    }

    private ListNode reverseKElements(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head.next;
        ListNode cur = head.next.next;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        pre.next = tail;
        return pre;
    }
}
