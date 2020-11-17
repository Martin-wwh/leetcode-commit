package stack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: stack
 * @Author: xuzq11
 * @CreateTime: 2020-09-24 10:23
 * @Description:
 */
public class GreaterNum {

    int[] nums = {2,1,2,4,3};

    @Test
    public void findGrearerNum(){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i=nums.length-1; i>=0; i--){
            while (!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        System.out.println(Arrays.toString(res));
    }

    //给你一个数组 T = [73, 74, 75, 71, 69, 72, 76, 73]，这个数组存放的是近几天的天气气温（这气温是铁板烧？不是的，这里用的华氏度）。
    // 你返回一个数组，计算：对于每一天，你还要至少等多少天才能等到一个更暖和的气温；如果等不到那一天，填 0 。
    @Test
    public void findWarmerDay(){
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i=T.length-1; i>=0; i--){
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]){
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }
        System.out.println(Arrays.toString(res));
    }
}
