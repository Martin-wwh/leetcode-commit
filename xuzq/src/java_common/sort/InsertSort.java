package java_common.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: leetcode-commit
 * @BelongsPackage: java_common.sort
 * @Author: xuzq11
 * @CreateTime: 2020-08-17 16:31
 * @Description: 插入排序
 */
public class InsertSort {

    int[] nums;

    public void sort(){
        for (int i=1; i<nums.length; i++){
            int j=i-1;
            int temp = nums[i];
            while (j>=0 && nums[j] > temp){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
    }

    @Test
    public void test() {
        nums = new int[]{2,5,4,17,6,2,45,81,7,14};
        sort();
        System.out.println(Arrays.toString(nums));
    }
}
