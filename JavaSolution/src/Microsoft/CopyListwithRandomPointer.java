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

    public RandomListNode copyRandomListNoExtraSpace(RandomListNode head) {    // 一定要会这种解法,ms问到过了
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode t = new RandomListNode(cur.label);
            t.next = cur.next;
            cur.next = t;
            cur = t.next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        RandomListNode p = cur.next;
        RandomListNode newHead = cur.next;
        while (p.next != null) {
            cur.next = p.next;
            p.next = p.next.next;
            cur = cur.next;
            p = p.next;
        }

        cur.next = null;
        return newHead;
    }
}
