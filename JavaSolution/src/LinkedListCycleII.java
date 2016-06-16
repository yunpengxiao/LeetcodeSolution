/**
 * Created by xyunpeng on 5/29/16.
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }

        if (p2 == null || p2.next == null) {
            return null;
        }

        p1 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}


//一个比较好的讲解 http://bookshadow.com/weblog/2015/07/10/leetcode-linked-list-cycle-ii/