#!/usr/bin/env  python
# -*- coding:utf-8 -*-

# @Create_time     :2020/9/15 21:48
# @Author          :wuweihong6
# @e-mail          :1454565178@qq.com
# @File            :mergetwolists
# @software        :PyCharm
# @description     :

'''
题目描述:将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
'''

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:  # 循环
        if l1 is None and l2 is None:
            return None
        link1, link2 = l1, l2
        link3, head = None, None
        while link1 or link2:
            if link1 and link2:
                if link1.val <= link2.val:
                    if head is None:
                        head = link3 = link1
                        link1 = link1.next
                    else:
                        link3.next = link1
                        link3 = link3.next
                        link1 = link1.next
                else:
                    if head is None:
                        head = link3 = link2
                        link2 = link2.next
                    else:
                        link3.next = link2
                        link3 = link3.next
                        link2 = link2.next
            elif link1:
                if head is None:
                    head = link1
                else:
                    link3.next = link1
                break
            else:
                if head is None:
                    head = link2
                else:
                    link3.next = link2
                break
        return head

    def mergeTwoLists2(self, l1: ListNode, l2: ListNode) -> ListNode:   # 递归
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists2(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists2(l2.next, l1)
            return l2

n1 = None
n2 = ListNode(0)

sl = Solution()
head1 = sl.mergeTwoLists2(n1, n2)
link31 = []
while head1:
    link31.append(head1.val)
    head1 = head1.next

print(link31)
