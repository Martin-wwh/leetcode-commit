import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuzq11
 * @CreateTime: 2020-08-31 16:01
 * @Description:
 */
public class ZhaoHang {

    /**
     * 题目描述
     * 有n个1~23的整数，写一个算法，求出有多少个相互不同的子集合的和为24点。
     */
    Set<Set<Integer>> result = new HashSet<>();
    int n = 11;
    int[] nums = {1,2,3,4,5,15,8,20,19,22,23};

    @Test
    public void test(){

        for (int i=0; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();
            set.add(i);
            dfs(i,nums[i], set);
        }
        System.out.println(result.size());
    }

    public void dfs(int start, int sum, Set<Integer> path){
        if (sum == 24){
            result.add(path);
            return;
        }
        if (sum < 24) {
            for (int i=start+1; i<n; i++){
                path.add(i);
                dfs(i, sum+nums[i], path);
                path.remove(i);
            }
        }

    }

    @Test
    public void canVisitAllRooms() {
        List<List<Integer>> rooms =  new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Collections.EMPTY_LIST);

        boolean[] dp = new boolean[rooms.size()];
        dp[0] = true;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        List<Integer> keyList = rooms.get(0);
        for (Integer key: keyList){
            queue.addLast(key);
        }
        while(!queue.isEmpty()){
            int room = queue.pop();
            if (dp[room]) continue;
            dp[room] = true;
            keyList = rooms.get(room);
            for (Integer key: keyList){
                queue.addLast(key);
            }
        }

        boolean res = true;
        for (boolean dpe : dp){
            res &= dpe;
        }
        System.out.println(res);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1=0,num2=0;
        int i=0,j=0;
        while(l1 != null){
            num1 = l1.val * (int)Math.pow(10,i++) + num1;
            l1 = l1.next;
        }
        while(l2 != null){
            num2 = l2.val * (int)Math.pow(10,j++) + num2;
            l2 = l2.next;
        }
        int num = num1+num2;
        int a = num % 10;
        num = num / 10;
        ListNode head = new ListNode(a);
        ListNode node = head;
        while (num != 0){
            a = num % 10;
            num = num /10;
            ListNode next = new ListNode(a);
            node.next = next;
            node = next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    @Test
    public void testA(){

        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        int j = 0;
        ListNode l4 = l2;
        while (j < 9){
            l4.next = new ListNode(9);
            l4 = l4.next;
            j++;
        }

        ListNode l3 = addTwoNumbers(l1,l2);
        int num1=0;
        int i=0;
        while(l3 != null){
            num1 = l3.val * (int)Math.pow(10,i++) + num1;
            l3 = l3.next;
        }
        System.out.println(num1);
    }
}
