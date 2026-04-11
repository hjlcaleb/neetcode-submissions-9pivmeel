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
    private List<Integer> leftBoundary;
    private List<Integer> leaves;
    private List<Integer> rightBoundary;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        leftBoundary = new ArrayList<>();
        leaves = new ArrayList<>();
        rightBoundary = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        if (root.left == null && root.right == null) return result;
        findBoundary(root.left, true, false);
        findBoundary(root.right, false, true);
        result.addAll(leftBoundary);
        result.addAll(leaves);
        result.addAll(rightBoundary);
        return result;
    }

    private void findBoundary(TreeNode node, boolean isLeft, boolean isRight) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        if (isLeft) {
            leftBoundary.add(node.val);
        } else if (isRight) {
            rightBoundary.add(0, node.val);
        }

        findBoundary(node.left, isLeft, isRight && node.right == null);
        findBoundary(node.right, isLeft && node.left == null, isRight);
    }
}
