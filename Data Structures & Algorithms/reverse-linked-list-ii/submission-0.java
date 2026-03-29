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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // get to the node before left
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode oneBeforeLeft = dummy;
        for (int i = 1; i < left; i++) {
            oneBeforeLeft = oneBeforeLeft.next;
        }

        // reverse [left, right] nodes
        ListNode tail = oneBeforeLeft.next;
        ListNode prev = null;
        ListNode curr = tail;
        for (int i = left; i <= right; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        tail.next = curr;
        oneBeforeLeft.next = prev;

        return dummy.next;
    }
}