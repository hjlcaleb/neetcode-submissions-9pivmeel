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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.remove();
            if (cur == null) {
                res.append("N,");
            } else {
                res.append(cur.val + ",");
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("N,")) return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int index = 1;

        while (!q.isEmpty() && index < nodes.length) {
            TreeNode node = q.remove();
            if (!nodes[index].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(node.left);
            }
            index++;
            if (index < nodes.length && !nodes[index].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(node.right);
            }
            index++;
        }

        return root;
    }
}
