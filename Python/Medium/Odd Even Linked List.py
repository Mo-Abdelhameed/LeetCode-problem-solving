from typing import Optional


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head

        odd_head = head
        even_head = head.next
        current = odd_head
        i = 0
        while current.next:
            next = current.next
            current.next = next.next

            if i % 2 == 0:
                last_odd = current
            i += 1
            current = next

        if i % 2 == 0:
            last_odd = current

        last_odd.next = even_head
        return odd_head
