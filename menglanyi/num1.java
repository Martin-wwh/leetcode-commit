package leetcode;

import jdk.nashorn.internal.runtime.logging.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 第一题 求一个数组中 两数之和等于目标数的下标
 * */

public class num1 {
    public static void main(String[] args) {
        num1 num1=new num1();
        int[] sums=new int[]{3,2,4};
        int[] s=num1.twoSum(sums,6);
        System.out.println(Arrays.toString(s));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            Integer val=map.get(target-nums[i]);
            if(null!=val&&val!=i){
                return new int[]{i,map.get(target-nums[i])};
            }
        }
        return new int[]{0,0};
    }
}
