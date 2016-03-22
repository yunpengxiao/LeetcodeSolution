/**
 * Created by xyunpeng on 3/20/16.
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode walker = dummy;
        ListNode runner = dummy;
        int i = 0;
        while (i <= n && runner != null) {
            runner = runner.next;
            i++;
        }

        while (runner != null) {
            runner = runner.next;
            walker = walker.next;
        }

        if (walker.next != null) {
            walker.next = walker.next.next;
        }

        return dummy.next;
    }
}
