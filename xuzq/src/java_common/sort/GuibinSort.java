package java_common.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.sort
 * @Author: xuzq11
 * @CreateTime: 2020-08-17 17:20
 * @Description: 归并排序
 */
public class GuibinSort {

    int[] nums;

    public void sort(int[] nums, int[] result, int start, int end){
        if (start >= end){
            return;
        }
        int mid = ((end-start)>>1) + start;
        int start1 = start;
        int end1 = mid;
        int start2 = mid+1; int end2 = end;
        sort(nums, result, start1, end1);
        sort(nums, result, start2, end2);
        int k = start;
        while(start1 <= end1 && start2 <= end2){
            result[k++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
        }
        while (start1 <= end1){
            result[k++] = nums[start1++];
        }
        while (start2 <= end2){
            result[k++] = nums[start2++];
        }
        for (int i=start; i<end; i++){
            nums[i] = result[i];
        }
    }

    @Test
    public void test() {
        nums = new int[]{2,5,4,17,6,2,45,81,7,14};
        int[] result = new int[nums.length];
        sort(nums,result, 0, nums.length-1);
        System.out.println(Arrays.toString(result));
    }
}
