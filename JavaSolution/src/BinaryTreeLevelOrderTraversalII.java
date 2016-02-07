/**
 * Created by xyunpeng on 2/6/16.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(0, level);
                level = new ArrayList<>();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                level.add(node.val);

                if (null != node.left) {
                    queue.offer(node.left);
                }

                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}


//完全不知道这一题的point在哪里,感觉跟I一样的