/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = null;
        dfs(root, p, q);
        return lca;
    }

    private boolean[] dfs(TreeNode curRoot, TreeNode p, TreeNode q) {
        if (curRoot == null || lca != null) {
            return new boolean[]{false, false};
        }

        boolean[] left = dfs(curRoot.left, p, q);
        boolean[] right = dfs(curRoot.right, p, q);

        boolean foundP = left[0] || right[0] || curRoot == p;
        boolean foundQ = left[1] || right[1] || curRoot == q;

        if (foundP && foundQ && lca == null) {
            lca = curRoot;
        }

        return new boolean[]{foundP, foundQ};
    }
}