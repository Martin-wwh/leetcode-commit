#!/usr/bin/env  python
# -*- coding:utf-8 -*-

# @Create_time     :2020/9/14 21:50
# @Author          :wuweihong6
# @e-mail          :1454565178@qq.com
# @File            :addtwonumbers
# @software        :PyCharm
# @description     :

'''
题目描述：
给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

'''


'''
题解:
按照本题的描述，链表的表示的是整数，整数加法的计算规则是从最低位一直计算到最高位。
按照题述，最低位是从链表的第一个节点开始，链表节点的下一个节点则比当前节点高一位，直到链表的尾节点为最高位。
则按照规则，只需从两个链表的头节点开始，两个链表从头节点开始对齐，将对齐的节点的值相加结果为val，同时考虑进位，
进位用（val // 10)表示，而在新的结果链表中，与这两个节点对齐的位置存放的值为(val%10)，进位的值在迭代到下一个节点时
与下一个对齐位置的结果值相加。迭代终止的条件是：两个链表均已遍历完成且进位也为0.
如示例中：(2->4->3) + (5->6->4)
初始时假设进位n=0
两个链表的头节点对齐位置的值为：（2，5）,则val = 2+5+0=7,进位n=val // 10=0,结果链表的头节点的值为val=val%10=7
第一个节点对齐位置的值为：（4,6）,则val = 4+6+0 = 10，进位n = 1，结果链表的第一个节点的值val = 0
第二个节点对齐位置的值为：（3,4）,则val = 3+4+1 = 8，进位n = 0，结果链表的第二个节点的值val = 8
此时已满足迭代终止条件，计算终止。
结果链表为：7->0->8
'''

class ListNode:

    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:

    def addTwoNumbers(self, l1:ListNode, l2:ListNode)->ListNode:
        last, curr, first = None, None, None
        link1, link2 = l1, l2
        n = 0
        while not (link1 is None and link2 is None and n==0):
            val = n
            if link1:
                val += link1.val
                link1 = link1.next
            if link2:
                val += link2.val
                link2 = link2.next
            n = val // 10
            val = val % 10
            curr = ListNode(val)
            if first is None:
                first = curr
                last = first
            else:
                last.next = curr
                last = curr
        return first

n1 = ListNode(2)
n2 = ListNode(4)
n3 = ListNode(3)

n4 = ListNode(5)
n5 = ListNode(6)
n6 = ListNode(4)

n1.next = n2
n2.next = n3

n4.next=n5
n5.next=n6
sl = Solution()
l3 = sl.addTwoNumbers(n1,n4)
link3 = []
while l3:
    link3.append(l3.val)
    l3 = l3.next
print(link3)



