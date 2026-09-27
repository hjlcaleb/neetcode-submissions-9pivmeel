/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int closest;
    public int closestValue(TreeNode root, double target) {
        closest = root.val;
        dfs(root, target);
        return closest;
    }

    private void dfs(TreeNode cur, double target) {
        if (cur == null) return;

        double curDiff = Math.abs(cur.val - target);
        double closestDiff = Math.abs(closest - target);
        if (closestDiff > curDiff
            || (closestDiff == curDiff && cur.val < closest)) {
            closest = cur.val;
        }

        if (cur.val > target) {
            dfs(cur.left, target);
        } else {
            dfs(cur.right, target);
        }
    }


}
