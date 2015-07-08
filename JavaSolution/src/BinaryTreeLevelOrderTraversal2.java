import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

/**
 * Created by xyunpeng on 7/7/15.
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null)
            return res;
        q.add(root);
        List<Integer> el = new ArrayList<Integer>();
        int cur = 0;
        int last = 1;
        while(!q.isEmpty()) {
            TreeNode t = q.poll();
            last--;
            el.add(t.val);
            if (t.left != null) {
                cur++;
                q.add(t.left);
            }
            if (t.right != null) {
                cur++;
                q.add(t.right);
            }
            if (last == 0) {
                last = cur;
                cur = 0;
                res.add(el);
                el = new ArrayList<Integer>();
            }
        }
        Collections.reverse(res);
        return res;
    }
}
