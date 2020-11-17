package java_common;

import org.junit.Test;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common
 * @Author: xuzq11
 * @CreateTime: 2020-05-28 14:25
 * @Description: 最大乘积子数组
 */
public class MaxProduct {

    public int maxProduct(int[] nums) {
//        暴力破解
//        int result = Integer.MIN_VALUE;
//        for(int i=0 ;i<nums.length; i++){
//            result = Math.max(result, nums[i]);
//            int midResult = nums[i];
//            for (int j=i+1; j<nums.length; j++){
//                midResult *= nums[j];
//                result = Math.max(result, midResult);
//            }
//        }
//        return result;

        int result = Integer.MIN_VALUE;
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0]=min[0]=nums[0];
        result = Math.max(result, max[0]);

        for (int i=1; i<n; i++){
            max[i] = Math.max(nums[i], Math.max(max[i-1]*nums[i], min[i-1]*nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i-1]*nums[i], min[i-1]*nums[i]));

            result = Math.max(result, max[i]);
        }
        return result;
    }

    public void rotate(int[] nums, int k) {
        for (int j=0; j<k; j++){
            int temp = nums[nums.length-1];
            for (int i=0; i<nums.length; i++){
                int a = nums[i];
                nums[i] = temp;
                temp = a;
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, 3);
    }
}
