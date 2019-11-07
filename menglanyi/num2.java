package leetcode;

/**
 * 两个非负整数处理成链表，求两数之和
 * */
public class num2 {
    public static void main(String[] args) {
        num2 num2 = new num2();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l1.next=new ListNode(9);
        ListNode result = num2.addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode listNode = new ListNode(0);
        ListNode listNode1 =listNode;
        while (null != l1 || null != l2) {
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            listNode.next = new ListNode((carry + l1.val + l2.val) % 10);
            carry=(carry+l1.val + l2.val) /10;
            l1 = l1.next;
            l2 = l2.next;
            listNode=listNode.next;
        }
        if(carry!=0){
            listNode.next=new ListNode(carry);
        }
        return listNode1.next;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}