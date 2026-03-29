# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:            
        # find length of list
        curr = head
        length = 0
        while curr:
            length += 1
            curr = curr.next
        
        # remove (length - n)th node from the front
        targetIndex = length - n
        if targetIndex == 0: return head.next
        curr = head
        i = 0
        for i in range(targetIndex - 1):
            curr = curr.next
        curr.next = curr.next.next  
        
        return head
            

