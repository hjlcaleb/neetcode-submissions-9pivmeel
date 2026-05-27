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
        List<String> result = new ArrayList<>();
        serializeDfs(root, result);
        return String.join(",", result);
    }

    private void serializeDfs(TreeNode cur, List<String> result) {
        if (cur == null) {
            result.add("N");
            return;
        }

        result.add(cur.val + "");
        serializeDfs(cur.left, result);
        serializeDfs(cur.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = {0};
        TreeNode root = deserializeDfs(index, nodes);
        return root;
    }

    private TreeNode deserializeDfs(int[] i, String[] nodes) {
        if (nodes[i[0]].equals("N")) {
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[i[0]]));

        i[0]++;
        root.left = deserializeDfs(i, nodes);
        root.right = deserializeDfs(i, nodes);
        return root;
    } 
}
