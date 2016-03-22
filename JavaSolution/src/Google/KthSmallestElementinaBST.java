package Google;

/**
 * Created by xyunpeng on 3/21/16.
 */
public class KthSmallestElementinaBST {
    int result;
    int count = 0;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return ;
        }
        helper(root.left);
        count++;
        if (count == k) {
            result = root.val;
        } else {
            helper(root.right);
        }
    }
}


//这题只是简单求过了,https://leetcode.com/discuss/68052/two-easiest-in-order-traverse-java