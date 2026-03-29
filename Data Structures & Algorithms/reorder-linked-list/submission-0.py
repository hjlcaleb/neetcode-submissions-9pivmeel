# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next or not head.next.next:
            return

        slow, fast = head, head
        # find midpoint of list
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
    
        # reverse list 2
        prev, curr = None, slow.next
        slow.next = None
        while curr:
            temp = curr.next
            curr.next = prev

            prev = curr
            curr = temp
        
        l1 = head
        l2 = prev
        
        while l2:
            tmp1 = l1.next
            tmp2 = l2.next

            l1.next = l2
            l2.next = tmp1

            l1 = tmp1
            l2 = tmp2
            

            
