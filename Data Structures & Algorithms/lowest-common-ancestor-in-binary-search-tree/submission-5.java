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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            return locateSplit(root, p, q);
        } else {
            return locateSplit(root, q, p);
        }
    }

    private TreeNode locateSplit(TreeNode node, TreeNode s, TreeNode l) {
        if (node == null) return null;

        if ((s.val <= node.val && node.val <= l.val)) {
            return node;
        }

        if (s.val > node.val) {
            return locateSplit(node.right, s, l);
        }

        if (l.val < node.val) {
            return locateSplit(node.left, s, l);
        }

        return null;

    } 
}
