# Doubly Linked List Node
class ListNode:
    def __init__(self, value):
        self.val = value
        self.next = None
        self.prev = None

class Deque:
    
    def __init__(self):
        self.head = ListNode(-1)
        self.tail = ListNode(-1)
        self.head.next = self.tail
        self.tail.prev = self.head

    def isEmpty(self) -> bool:
        return self.head.next == self.tail

    def append(self, value: int) -> None:
        new_node = ListNode(value)
        last_node = self.tail.prev # last real node
        
        last_node.next = new_node
        new_node.prev = last_node
        new_node.next = self.tail
        self.tail.prev = new_node

    def appendleft(self, value: int) -> None:
        new_node = ListNode(value)
        temp = self.head.next
        
        self.head.next = new_node
        new_node.prev = self.head
        new_node.next = temp
        temp.prev = new_node

    def pop(self) -> int:
        if self.isEmpty():
            return -1
        target_node = self.tail.prev
        value = target_node.val
        prev_node = target_node.prev
        prev_node.next = self.tail
        self.tail.prev = prev_node

        return value

    def popleft(self) -> int:
        if self.isEmpty():
            return -1
        target_node = self.head.next
        value = target_node.val
        next_node = target_node.next
        next_node.prev = self.head
        self.head.next = next_node

        return value
        
