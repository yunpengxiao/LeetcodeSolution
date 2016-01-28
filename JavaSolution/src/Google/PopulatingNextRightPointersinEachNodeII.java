package Google;

/**
 * Created by xyunpeng on 1/27/16.
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode p = dummy;
        while (root != null) {
            if (root.left != null) {
                p.next = root.left;
                p = p.next;
            }

            if (root.right != null) {
                p.next = root.right;
                p = p.next;
            }

            root = root.next;
            if (root == null) {
                root = dummy.next;
                p = dummy;
                dummy.next = null;
            }
        }
    }
}


//参考别人家的代码: https://leetcode.com/discuss/67291/java-solution-with-constant-space
//自己真想不出来,这题好像也没什么算法