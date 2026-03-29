/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        ListNode skip = curr;
        while (skip != null && skip.next != null) {
            curr = curr.next;
            skip = skip.next.next;
            if (curr == skip) {
                return true;
            }
        }
        return false;
    }
}
