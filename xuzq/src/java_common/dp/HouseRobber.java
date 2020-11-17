package java_common.dp;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.dp
 * @Author: xuzq11
 * @CreateTime: 2020-09-19 08:51
 * @Description:
 */
public class HouseRobber {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    @Test
    public void test(){
        int[] nums = {2,7,9,3,1};

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for (int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        System.out.println(dp[nums.length-1]);
    }


    /**
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     */
    @Test
    public void test1(){
        int[] nums = {2,7,9,3,1};

        int dp0 = nums[0];
        int dp1 = Math.max(nums[0],nums[1]);

        for (int i=2; i<nums.length-1; i++){
            int dp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = dp;
        }

        int result1 = dp1;

        dp0 = nums[1];
        dp1 = Math.max(nums[1],nums[2]);

        for (int i=3; i<nums.length; i++){
            int dp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = dp;
        }

        int result2 = dp1;

        System.out.println(Math.max(result1, result2));
    }

    /**
     * 这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    Map<TreeNode, Integer> memoMap = new HashMap<>();

    @Test
    public void test2(){

    }

    public int dp(TreeNode node){
        if (node == null) return 0;
        if (memoMap.containsKey(node)){
            return memoMap.get(node);
        }
        //抢
        int robResult = node.val + (node.left == null ? 0 : dp(node.left.left) + dp(node.left.right))
                + (node.right == null ? 0 : dp(node.right.left) + dp(node.right.right));

        //不抢
        int noRobResult = dp(node.left) + dp(node.right);
        int res = Math.max(robResult, noRobResult);
        memoMap.put(node, res);
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) return resList;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            resList.add(top.val);
            if (top.right != null) stack.push(top.right);
            if (top.left != null) stack.push(top.left);
        }
        return resList;
    }
}
