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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.add(root.val);
        if (isLeaf(root)) return result;
        
        // 1. add left boundary
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                result.add(curr.val);
            }
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        // 2. recursively add leaf nodes
        addLeaves(root, result);

        // 3. add right boundary
        Stack<Integer> rightNodes = new Stack<>();
        curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) {
                rightNodes.push(curr.val);
            }

            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        while (!rightNodes.isEmpty()) {
            result.add(rightNodes.pop());
        }
        return result;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.val);
        } else {
            if (node.left != null) {
                addLeaves(node.left, result);
            }
            if (node.right != null) {
                addLeaves(node.right, result);
            }
        }
    }
}
