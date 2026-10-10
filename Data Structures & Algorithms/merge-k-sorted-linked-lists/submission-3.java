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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.remove();
            cur.next = temp;
            cur = cur.next;
            temp = temp.next;
            if (temp != null) {
                minHeap.add(temp);
            }
        }
        return dummy.next;
    }
}
