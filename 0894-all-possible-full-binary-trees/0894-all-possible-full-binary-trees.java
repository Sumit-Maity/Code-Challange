import java.util.*;
class Solution {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {

        if (memo.containsKey(n))
            return memo.get(n);

        List<TreeNode> res = new ArrayList<>();
        if (n % 2 == 0)
            return res;
        if (n == 1) {
            res.add(new TreeNode(0));
            memo.put(n, res);
            return res;
        }
        for (int leftNodes = 1; leftNodes < n; leftNodes += 2) {

            int rightNodes = n - 1 - leftNodes;

            List<TreeNode> leftTrees = allPossibleFBT(leftNodes);
            List<TreeNode> rightTrees = allPossibleFBT(rightNodes);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;

                    res.add(root);
                }
            }
        }
        memo.put(n, res);
        return res;
    }
}