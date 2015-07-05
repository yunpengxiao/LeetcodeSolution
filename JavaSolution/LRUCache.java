import java.io.*;
import java.util.HashMap;

public class LRUCache
{
    class Node
    {
        Node pre, next;
        int key;
        int val;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    private int cap;
    private int num;
    private HashMap<Integer, Node> map;
    private Node first, last;
    
    public LRUCache(int capacity)
    {
        this.cap = capacity;
        num = 0;
        map = new HashMap<Integer, Node>();
        first = null;
        last = null;
    }
    
    public int get(int key)
    {
        Node n = map.get(key);
        if (n == null)
            return -1;
        else if (n != last)
        {
            if (n == first)
                first = first.next;
            else
                n.pre.next = n.next;
            n.next.pre = n.pre;
            n.pre = last;
            last.next = n;
            n.next = null;
            last = n;
        }
        return n.val;
    }
    
    public void set(int key, int value)
    {
        Node n = map.get(key);
        if (n != null)
        {
            n.val = value;
            if (n != last)
            {
                if (n == first)
                    first = first.next;
                else
                    n.pre.next = n.next;
                n.next.pre = n.pre;
                n.pre = last;
                last.next = n;
                n.next = null;
                last = n;
            }   
        }
        else
        {
            Node nn = new Node(key, value);
            if (num >= cap)
            {
                map.remove(first.key);
                first = first.next;
                if (first != null)
                    first.pre = null;
                else
                    last = null;
                num--;
            }
            if (first == null || last == null)
                first = nn;
            else
                last.next = nn;
            nn.pre = last;
            last = nn;
            map.put(key, nn);
            num++;
        }
        
    }
}
