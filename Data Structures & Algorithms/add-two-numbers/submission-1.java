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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carryOver = 0;
        int sum = 0;

        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carryOver;
            if (sum >= 10) {
                carryOver = 1;
                sum -= 10;
            } else {
                carryOver = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = l1.val + carryOver;
            if (sum >= 10) {
                carryOver = 1;
                sum -= 10;
            } else {
                carryOver = 0;
            }
            curr.next = new ListNode(sum);
            l1 = l1.next;
            curr = curr.next;
        } 

        while (l2 != null) {
            sum = l2.val + carryOver;
            if (sum >= 10) {
                carryOver = 1;
                sum -= 10;
            } else {
                carryOver = 0;
            }
            curr.next = new ListNode(sum);
            l2 = l2.next;
            curr = curr.next;
        }

        if (carryOver != 0) {
            curr.next = new ListNode(carryOver);
        }

        return dummy.next;
    }
}
