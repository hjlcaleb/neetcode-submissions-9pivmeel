# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if not head or not head.next:
            return False
        
        fast, slow = head, head

        while True:
            if fast == None:
                return False
            fast = fast.next.next
            slow = slow.next

            if fast == slow:
                return True