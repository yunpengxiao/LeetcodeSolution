package FaceBook;

import java.util.PriorityQueue;

/**
 * Created by xyunpeng on 1/5/16.
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pqueue = new PriorityQueue<ListNode>(lists.length, new ListComparator());
        for (ListNode ln : lists) {
            if (ln != null)
                pqueue.add(ln);
        }

        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (!pqueue.isEmpty()) {
            p.next = pqueue.poll();
            if (p.next.next != null)
                pqueue.add(p.next.next);
            p = p.next;
        }

        return dummy.next;
    }

    class ListComparator implements Comparator<ListNode>{

        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    }
}
