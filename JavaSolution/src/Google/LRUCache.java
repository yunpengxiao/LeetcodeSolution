package Google;

/**
 * Created by xyunpeng on 2/27/16.
 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cacheIndex;
    Node headNode, tailNode;
    int maxSize;


    public LRUCache(int capacity) {
        this.cacheIndex = new HashMap<>();
        this.maxSize = capacity;
        this.headNode = new Node(0, 0);
        this.tailNode = headNode;
    }

    public int get(int key) {
        if (!cacheIndex.containsKey(key)) {
            return -1;
        }

        Node t = cacheIndex.get(key);
        if (headNode != t) {
            t.pre.next = t.next;
            if (t.next != null) t.next.pre = t.pre;
            headNode.next = t;
            t.pre = headNode;
            t.next = null;
            headNode = t;
        }
        return t.value;
    }

    public void set(int key, int value) {
        if (maxSize == 0) return ;
        if (cacheIndex.containsKey(key)) {
            Node t = cacheIndex.get(key);
            if (t.value != value) {
                t.value = value;
            }

            if (headNode != t) {
                t.pre.next = t.next;
                if (t.next != null) t.next.pre = t.pre;
                headNode.next = t;
                t.pre = headNode;
                t.next = null;
                headNode = t;
            }
        } else {
            Node t = new Node(key, value);
            cacheIndex.put(key, t);
            if (cacheIndex.size() > maxSize) {
                cacheIndex.remove(tailNode.next.key);
                if (tailNode.next.next != null) {
                    tailNode.next.next.pre = tailNode;
                }
                tailNode.next = tailNode.next.next;

            }
            headNode.next = t;
            t.pre = headNode;
            t.next = null;
            headNode = t;
        }
    }
}
