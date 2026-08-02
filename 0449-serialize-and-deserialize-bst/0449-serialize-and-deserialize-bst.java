public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString().trim();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        sb.append(root.val).append(" ");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }
    private int index;

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] values = data.split(" ");
        int[] preorder = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            preorder[i] = Integer.parseInt(values[i]);
        }

        index = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode build(int[] preorder, int min, int max) {
        if (index == preorder.length) {
            return null;
        }

        int val = preorder[index];

        if (val < min || val > max) {
            return null;
        }
         index++;
        TreeNode root = new TreeNode(val);
        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }
}