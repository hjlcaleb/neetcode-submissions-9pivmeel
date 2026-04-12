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
        ListNode curr = dummy;
        int k = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (int i = 0; i < k; i++) {
            minHeap.add(lists[i]);
        }

        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.remove();
            curr.next = temp;
            temp = temp.next;
            if (temp != null) {
                minHeap.add(temp);
            }
            curr = curr.next;
        }

        return dummy.next;
    }
}
