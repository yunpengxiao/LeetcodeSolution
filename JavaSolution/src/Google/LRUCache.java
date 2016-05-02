package Google;

/**
 * Created by xyunpeng on 2/27/16.
 */
/*public class LRUCache {
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
}*/

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

    Map<Integer, Node> nodeMap;
    int capacity;
    Node first, last;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        this.first = new Node(0, 0);
        this.last = new Node(0, 0);
        first.next = null;
        first.pre = last;
        last.next = first;
        last.pre = null;
    }

    public int get(int key) {
        Node keyNode= nodeMap.get(key);;
        if (keyNode == null) {
            return -1;
        } else {
            deleteNode(keyNode);
            addToFirst(keyNode);
            return keyNode.value;
        }
    }

    public void set(int key, int value) {
        if (capacity == 0) {
            return ;
        }
        Node keyNode = nodeMap.get(key);
        if (keyNode == null) {
            keyNode = new Node(key, value);
            if (nodeMap.size() == capacity) {
                nodeMap.remove(last.next.key);
                deleteNode(last.next);
            }
            nodeMap.put(key, keyNode);
        } else {
            deleteNode(keyNode);
            keyNode.value = value;
        }
        addToFirst(keyNode);
    }

    private void deleteNode(Node keyNode) {
        keyNode.pre.next = keyNode.next;
        keyNode.next.pre = keyNode.pre;
    }

    private void addToFirst(Node keyNode) {
        keyNode.next = first;
        keyNode.pre = first.pre;
        keyNode.pre.next = keyNode;
        keyNode.next.pre = keyNode;
    }
}


//自己实现的第二版的LRU cache没有一丝多余的代码,十分美观,参考了https://leetcode.com/discuss/81106/java-easy-version-to-understand
//在实现双向链表的时候,建立头尾两个dummy node,所有的新node都插入这两个点中间,这样都不用处理边界情况