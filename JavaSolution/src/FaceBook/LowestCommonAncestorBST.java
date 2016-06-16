package FaceBook;

import javax.swing.tree.TreeNode;

/**
 * Created by xyunpeng on 1/20/16.
 */
public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}

//这个算法在最坏情况下是O(n)的复杂度,就是当这个树长得跟链表一样时

