/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> ogToCopy = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            ogToCopy.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        Node dummy = ogToCopy.get(curr);
        while (curr != null) {
            ogToCopy.get(curr).next = ogToCopy.get(curr.next);
            ogToCopy.get(curr).random = ogToCopy.get(curr.random);
            curr = curr.next;
        }
        return dummy;
    }
}
