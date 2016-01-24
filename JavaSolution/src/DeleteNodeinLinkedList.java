/**
 * Created by xyunpeng on 1/23/16.
 */
public class DeleteNodeinLinkedList {
    public void deleteNode(ListNode node) {
        ListNode p = node;
        while (p.next != null) {
            p.val = p.next.val;
            if (p.next.next == null) {
                p.next = null;
                break;
            }
            p = p.next;
        }
    }
}
