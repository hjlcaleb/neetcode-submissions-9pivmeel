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
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        // find midpoint w/ slow & fast ptrs
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        // reverse the second half
        ListNode prev = null;
        ListNode curr = secondHalf;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        secondHalf = prev;

        // interleave the two
        ListNode curr1 = head;
        ListNode curr2 = secondHalf;
        while (curr2 != null) {
            ListNode temp1 = curr1.next;
            curr1.next = curr2;
            ListNode temp2 = curr2.next;
            curr2.next = temp1;

            curr1 = temp1;
            curr2 = temp2;
        }
    }
}
