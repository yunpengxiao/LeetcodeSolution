package Microsoft;

/**
 * Created by xyunpeng on 2/20/16.
 */
public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> new2old = new HashMap<>();
        RandomListNode p = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode last = dummy;
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            new2old.put(p, newNode);
            last.next = newNode;
            last = newNode;
            p = p.next;
        }

        p = head;
        while (p != null) {
            new2old.get(p).random = new2old.get(p.random);
            p = p.next;
        }

        return dummy.next;
    }
}
