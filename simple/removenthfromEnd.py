#!/usr/bin/env  python
# -*- coding:utf-8 -*-

# @Create_time     :2020/9/14 22:33
# @Author          :wuweihong6
# @e-mail          :1454565178@qq.com
# @File            :removenthfromEnd
# @software        :PyCharm
# @description     :

'''
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
'''


class ListNode:

    def __init__(self, x):
        self.val = x
        self.next = None


class Solution2:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        prev = head
        s = "prev" + ".next"*n
        m = eval(s)
        if m == None:# 要删除的点是第一个节点
            return prev.next# 删除第一个节点
        while eval(s+".next") != None: #n+1个next，多往后找一个，以防止要删除的是最后一个
            prev = prev.next
        if prev.next != None:
        # prev.val = prev.next.val#这两行的代码相当于是删除当前节点那道题，如果只用n个.next的情况下
            prev.next = prev.next.next
        else: #删除的点是最后一个
            prev.next = None
        return head


class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        dummy = ListNode(0)
        dummy.next = head
        curr, last = dummy, dummy
        offset = 0
        while last:
            if offset < n:
                last = last.next
                offset += 1
            elif last.next is not None:
                curr = curr.next
                last = last.next
            else:
                last = last.next
        curr.next = curr.next.next
        return dummy.next


n1 = ListNode(1)
n2 = ListNode(2)
n3 = ListNode(3)
n4 = ListNode(4)
n5 = ListNode(5)
n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
sl = Solution2()
head = sl.removeNthFromEnd(n1, 2)
link = []
while head:
    link.append(head.val)
    head = head.next

print(link)


