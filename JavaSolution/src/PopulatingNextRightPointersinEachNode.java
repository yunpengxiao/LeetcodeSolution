/**
 * Created by xyunpeng on 1/27/16.
 */
public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return ;
        }

        TreeLinkNode level = root;
        while (level.left != null) {
            TreeLinkNode p = level;
            while (p != null) {
                p.left.next = p.right;
                if (p.next != null) p.right.next = p.next.left;
                p = p.next;
            }
            level = level.left;
        }
    }
}
