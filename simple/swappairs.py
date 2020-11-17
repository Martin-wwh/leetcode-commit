#!/usr/bin/env  python
# -*- coding:utf-8 -*-

# @Create_time     :2020/9/16 23:55
# @Author          :wuweihong6
# @e-mail          :1454565178@qq.com
# @File            :swappairs
# @software        :PyCharm
# @description     :


'''
题目描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
'''


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def swapPairs(self, head: ListNode) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        curr_prev = dummy
        curr = dummy.next
        if curr:
            other = curr.next
        else:
            other = None
        while curr and other:
            curr_prev.next = other
            curr.next = other.next
            other.next = curr
            curr_prev = curr
            curr = curr.next
            if curr:
                other = curr.next
            else:
                other = None
        return dummy.next

n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)

n1.next = n2
# n2.next = n3
# n3.next = n4

sl = Solution()
head = sl.swapPairs(None)
l3 = []
while head:
    l3.append(head.val)
    head = head.next

print(l3)

