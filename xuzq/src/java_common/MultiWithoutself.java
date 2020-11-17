package java_common;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-06-18 10:01
 * @Description: 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 */
public class MultiWithoutself {

    public int[] productExceptSelf(int[] nums) {
        int[] L = new int[nums.length];
//        int[] R = new int[nums.length];
        L[0] = 1;
//        R[nums.length-1] = 1;
        for (int i=1; i<nums.length; i++){
            L[i] = nums[i-1] * L[i-1];
        }
//        for (int i=nums.length-2; i>=0; i--){
//            R[i] = nums[i+1] * R[i+1];
//        }
//        int[] result = new int[nums.length];
//        for (int i=0; i<nums.length; i++){
//            result[i] = L[i] * R[i];
//        }
        int R = 1;
        for (int i = nums.length - 1; i>=0; i--){
            L[i] = L[i] * R;
            R = R * nums[i];
        }
        System.out.println(Arrays.toString(L));
        return L;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4};
        productExceptSelf(nums);
    }
}
