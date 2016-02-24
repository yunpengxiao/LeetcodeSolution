package Microsoft;

/**
 * Created by xyunpeng on 2/23/16.
 */
public class FlattenBinaryTreetoLinkedList {
    TreeNode pre;                                      //这个用来存前一次运行的root
    public void flatten(TreeNode root) {
        if (root == null) {
            return ;
        }

        flatten(root.right);                           //此时pre被更新为root.right
        flatten(root.left);                            //此时left与right连接上了,并且pre被置成了left
        root.left = null;
        root.right = pre;
        pre = root;
    }
}


//参考了天才代码: https://leetcode.com/discuss/30719/my-short-post-order-traversal-java-solution-for-share