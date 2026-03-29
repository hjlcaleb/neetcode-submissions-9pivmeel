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
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        int k = lists.length;

        for (int i = 0; i < k; i++) {
            minHeap.add(lists[i]);
        }

        ListNode curr = dummy;
        while (!minHeap.isEmpty()) {
            curr.next = minHeap.poll();
            curr = curr.next;
            if (curr.next != null) {
                minHeap.add(curr.next);
            }
        }
        return dummy.next;
    }
}
