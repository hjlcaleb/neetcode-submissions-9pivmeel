/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "N";
        String encoding = "";
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            if (cur != null) {
                int size = (cur.children != null) ? cur.children.size() : 0;
                encoding += cur.val + "#" + size + ",";
                for (Node child : cur.children) {
                    q.add(child);
                }
            } else {
                encoding += "N,";
            }
        }
        return encoding;
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.equals("N")) return null;
        String[] nodes = data.split(",");
        String[] rootComponents = nodes[0].split("#");
        int rootVal = Integer.parseInt(rootComponents[0]);
        int rootChildrenSize = Integer.parseInt(rootComponents[1]);
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        Node root = new Node(rootVal);
        if (rootChildrenSize != 0) {
            root.children = new ArrayList<>();
        }

        q.add(new Pair<>(root, rootChildrenSize));
        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            Pair<Node, Integer> cur = q.remove();
            Node parent = cur.getKey();
            int numChildren = cur.getValue();

            for (int j = 0; j < numChildren; j++) {
                String[] childParts = nodes[i++].split("#");
                int childVal = Integer.parseInt(childParts[0]);
                int childCount = Integer.parseInt(childParts[1]);
                Node childNode = new Node(childVal);
                if (childCount != 0) {
                    childNode.children = new ArrayList<>();
                }
                parent.children.add(childNode);
                q.add(new Pair<>(childNode, childCount));
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
