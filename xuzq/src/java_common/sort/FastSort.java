package java_common.sort;

import org.junit.Test;

import java.util.Random;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.sort
 * @Author: xuzq11
 * @CreateTime: 2020-06-19 09:20
 * @Description: 快排 思想,作比较,每一轮选一个基准值,比标准值小的放左边,大的放右边
 */
public class FastSort {

    //双边遍历
    public void sort(int[] nums, int start, int end){
        if (start >= end) return;

        //基准下标
        int standardIndex = partition(nums, start, end);

        sort(nums, start, standardIndex-1);
        sort(nums, standardIndex+1, end);

    }

    public int partition(int[] nums, int start, int end){

        //随机选择基准数字，尽可能防止倒序数组，导致退化为o(n^2)
        Random random = new Random();
        int index = random.nextInt(nums.length);

        int temp = nums[start];
        nums[start] = nums[index];
        nums[index] = temp;

        int standardNum = nums[start];
        int left = start;
        int right = end;

        while (left < right){
            while(left < right && nums[right] >= standardNum){
                right--;
            }
            while (left < right && nums[left] <= standardNum){
                left++;
            }

            if (left < right){
                int num = nums[left];
                nums[left] = nums[right];
                nums[right] = num;
            }
        }

        //基准交换
        nums[start] = nums[left];
        nums[left] = standardNum;

        return left;
    }

    @Test
    public void test() {
        int[] nums = {2,5,4,17,6,2,45,81,7,14};
        sort(nums, 0, nums.length-1);
        for (int num : nums){
            System.out.print(num  + "\t");
        }
    }
}
