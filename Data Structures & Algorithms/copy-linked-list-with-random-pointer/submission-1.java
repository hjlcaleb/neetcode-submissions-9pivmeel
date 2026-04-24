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
        Map<Node, Node> originalToNew = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            originalToNew.put(cur, newNode);
            cur = cur.next;
        }

        Node dummy = new Node(-1);
        Node ptr = dummy;
        cur = head;
        while (cur != null) {
            ptr.next = originalToNew.get(cur);
            ptr = ptr.next;
            ptr.random = originalToNew.get(cur.random);
            cur = cur.next;
        }
        return dummy.next;
    }
}
