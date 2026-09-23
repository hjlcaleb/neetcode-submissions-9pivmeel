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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode groupPrev = dummy;
        int i = 0;
        while (true) {
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) {
                break;
            }

            ListNode groupNext = kth.next;
            ListNode groupStart = groupPrev.next;

            kth.next = null;

            groupPrev.next = reverseList(groupStart);
            groupStart.next = groupNext;
            groupPrev = groupStart;
        }
        return dummy.next;
    }

    private ListNode getKthNode(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    
}
