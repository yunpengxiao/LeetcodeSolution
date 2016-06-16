package Google;

/**
 * Created by xyunpeng on 5/14/16.
 */
public class ClosestBinarySearchTreeValueII {
    class Pair implements Comparable<Pair> {
        double diff;
        int val;

        public Pair(double diff, int val) {
            this.diff = diff;
            this.val = val;
        }

        public int compareTo(Pair p) {
            if (this.diff > p.diff) {
                return -1;
            } else if (this.diff < p.diff) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair> pp = new PriorityQueue<>();
        buildQueue(root, target, k, pp);
        List<Integer> result = new ArrayList<>();
        while (!pp.isEmpty()) {
            result.add(pp.poll().val);
        }
        return result;
    }

    private void buildQueue(TreeNode root, double target, int k, PriorityQueue<Pair> pp) {
        if (root == null) {
            return ;
        }

        Pair tp = new Pair(Math.abs(target - root.val), root.val);
        pp.offer(tp);
        if (pp.size() > k) {
            pp.poll();
        }
        buildQueue(root.left, target, k, pp);
        buildQueue(root.right, target, k, pp);
    }
}


//我这个解法完全没用到BST的性质,感觉什么BT都可以用,建一个size为k的max heap就可以了,遍历完整个树那他里面存的就是那k个元素,时间复杂度为nlogk,基本上属于解法中垫底的,但是实现起来比较方便
//实际上不用一个PriorityQueue而只需要一个size为k的数组,利用bst的性质,这里有个简单的解法(最底下的代码最简单):https://leetcode.com/discuss/55240/ac-clean-java-solution-using-two-stacks
//但是实际上这里可以更简单