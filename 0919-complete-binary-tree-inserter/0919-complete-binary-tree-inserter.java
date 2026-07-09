import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> candidates;

    public CBTInserter(TreeNode root) {
        this.root = root;
        candidates = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node.left == null || node.right == null) {
                candidates.offer(node);
            }

            if (node.left != null) {
                q.offer(node.left);
            }

            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }
    public int insert(int val) {
        TreeNode parent = candidates.peek();
        TreeNode newNode = new TreeNode(val);

        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
            candidates.poll(); 
        }
        candidates.offer(newNode);
        return parent.val;
    }
    public TreeNode get_root() {
        return root;
    }
}