package Microsoft;

/**
 * Created by xyunpeng on 2/11/16.
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;

        while (true) {
            if (pa == pb) {
                return pa;
            }

            pa = (pa == null)? headB: pa.next;
            pb = (pb == null)? headA: pb.next;
        }

    }
}
