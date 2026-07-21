public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }
    private int index;
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;
        return build(arr);
    }
    private TreeNode build(String[] arr) {
        if (arr[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(arr[index++]));
        node.left = build(arr);
        node.right = build(arr);
        return node;
    }
}