#!/usr/bin/env  python
# -*- coding:utf-8 -*-

# @Create_time     :2020/9/16 1:41
# @Author          :wuweihong6
# @e-mail          :1454565178@qq.com
# @File            :mergeKLists
# @software        :PyCharm
# @description     :


'''
题目描述：给你一个链表数组，每个链表都已经按升序排列。
         请你将所有链表合并到一个升序链表中，返回合并后的链表。


示例 1：

输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6
示例 2：

输入：lists = []
输出：[]
示例 3：

输入：lists = [[]]
输出：[]

提示：

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
'''


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:

    def mergeKLists(self, lists) -> ListNode:
        import heapq
        dummy = ListNode(0)
        p = dummy
        head = []
        for i in range(len(lists)):
            if lists[i]:
                heapq.heappush(head, (lists[i].val, i))
                lists[i] = lists[i].next
        while head:
            val, idx = heapq.heappop(head)
            p.next = ListNode(val)
            p = p.next
            if lists[idx]:
                heapq.heappush(head, (lists[idx].val, idx))
                lists[idx] = lists[idx].next
        return dummy.next


n1 = None
n2 = None
n3 = None
lists = [n1,n2,n3]

nums = [[1,4,5],[1,3,4],[2,6]]
i = 0
for num in nums:
    n = None
    for item in num:
        if lists[i] is None:
            n = lists[i] = ListNode(item)
        else:
            n.next = ListNode(item)
            n = n.next
    i += 1
sl = Solution()
dummpy = sl.mergeKLists(lists)

