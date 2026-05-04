/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> oldToNew;

    public Node cloneGraph(Node node) {
        oldToNew = new HashMap<>();
        return dfs(node);
    }

    private Node dfs(Node curNode) {
        if (curNode == null) {
            return null;
        }

        if (oldToNew.containsKey(curNode)) {
            return oldToNew.get(curNode);
        }

        Node copy = new Node(curNode.val);
        oldToNew.put(curNode, copy);
        
        for (Node neighbor : curNode.neighbors) {
            copy.neighbors.add(dfs(neighbor));
        }

        return copy;
    }
}